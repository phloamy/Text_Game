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
        level.setPlayer(player);

        CommandParser parser = new CommandParser();
        parser.addCommand(new DropCommand());
        parser.addCommand(new PickupCommand());
        parser.addCommand(new EnterCommand());
        parser.addCommand(new InventoryCommand());
        parser.addCommand(new LookCommand());

        String response = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.print("> ");

            response = in.nextLine();

            if (response.equals("quit")) break;
            Command nextCommand = parser.parseCommand(response);
            if (nextCommand != null) {
                nextCommand.run(level);
            }

            System.out.println();
            level.updateEntities();
        } while (true);
    }
}