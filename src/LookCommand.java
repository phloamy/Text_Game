public class LookCommand extends Command {

    public LookCommand() {
        super("look");
    }
    @Override
    public void run(Level level) {
        Player player = level.getPlayer();

        System.out.println("You can go to the: " + player.getCurrentRoom().getNeighborNames());
        System.out.println("The " + player.getCurrentRoom().getName() + " contains: " + player.getCurrentRoom().getItemNames());
        System.out.println("The entities present are: " + player.getCurrentRoom().getEntityNames());
    }
}
