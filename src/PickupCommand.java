public class PickupCommand extends Command {

    public PickupCommand() {
        super("pickup");
    }

    @Override
    public void run(Level level) {
        Player player = level.getPlayer();

        if (player.pickUp(argumentString)) {
            System.out.println("You picked up the " + argumentString + " and added it to your inventory");
        } else {
            System.out.println("The " + player.getCurrentRoom().getName() + " does not contain the " + argumentString);
        }
    }
}
