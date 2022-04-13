import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Level level = new Level();
        level.addRoom("hall");
        level.addRoom("closet");
        level.addRoom("dungeon");

        level.addUndirectedEdge("hall", "dungeon");
        level.addUndirectedEdge("hall", "closet");

        level.getRoom("hall").addItem(new Item("sword", "It is dangerous to go alone"));
        level.getRoom("hall").addItem(new Item("apple", "Cronch"));

        new Popstar(level.getRoom("dungeon"), "popstar", "fanboy");
        new Chicken(level.getRoom("closet"), "cluck", "gobble gobble");

        Player player = new Player(level.getRoom("hall"));

        String response = "";
        Scanner in = new Scanner(System.in);

        List<Command> commands = new ArrayList<>();
        commands.add(new Command("look", 0) {
            @Override
            public void run(String input, Player player) {
                System.out.println("You can go to the: " + player.getCurrentRoom().getNeighborNames());
                System.out.println("The " + player.getCurrentRoom().getName() + " contains: " + player.getCurrentRoom().getItemNames());
                System.out.println("The entities present are: " + player.getCurrentRoom().getEntityNames());
            }
        });
        commands.add(new Command("enter", 1) {
            @Override
            public void run(String input, Player player) {
                String[] sections = input.split(" ");

                if (!player.moveTo(sections[1])) {
                    System.out.println("Cannot move to the " + sections[1]);
                }
            }
        });
        commands.add(new Command("pickup", 1) {
            @Override
            public void run(String input, Player player) {
                String[] sections = input.split(" ");

                if (player.pickUp(sections[1])) {
                    System.out.println("You picked up the " + sections[1] + " and added it to your inventory");
                } else {
                    System.out.println("The " + player.getCurrentRoom().getName() + " does not contain the " + sections[1]);
                }
            }
        });
        commands.add(new Command("drop", 1) {
            @Override
            public void run(String input, Player player) {
                String[] sections = input.split(" ");

                if (player.drop(sections[1])) {
                    System.out.println("You dropped the " + sections[1] + " in the " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("You do not have a" + (sections[1].substring(0, 1).matches("[aeiouAEIOU]") ? "n" : "") + " " + sections[1]);
                }
            }
        });
        commands.add(new Command("inventory", 0) {
            @Override
            public void run(String input, Player player) {
                System.out.println("You currently have: " + player.getContainer().getItemNames());
            }
        });

        do {

            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.print("What would you like to do: ");

            response = in.nextLine();

            if (response.equals("quit")) break;

            if (!runCommands(commands, response, player)) {
                displayCommands(commands);
            }

            System.out.println();
            level.updateEntities();
        } while (true);
    }

    public static boolean runCommands(List<Command> commands, String input, Player player) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.run(input, player);
                return true;
            }
        }

        return false;
    }

    public static void displayCommands(List<Command> commands) {
        System.out.println("That command was invalid. You can: ");
        for (Command command : commands) {
            System.out.println(command);
        }
    }
}