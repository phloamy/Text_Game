public class DropCommand extends Command {

    public DropCommand() {
        super("drop");
    }
    @Override
    public void run(Level level) {
        Player player = level.getPlayer();

        if (player.drop(argumentString)) {
            System.out.println("You dropped the " + argumentString + " in the " + player.getCurrentRoom().getName());
        } else {
            System.out.println("You do not have a" + (argumentString.substring(0, 1).matches("[aeiouAEIOU]") ? "n" : "") + " " + argumentString);
        }
    }
}
