public class InventoryCommand extends Command {

    public InventoryCommand() {
        super("inventory");
    }
    @Override
    public void run(Level level) {
        System.out.println("You currently have: " + level.getPlayer().getContainer().getItemNames());
    }
}
