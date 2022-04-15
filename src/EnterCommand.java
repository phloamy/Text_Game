public class EnterCommand extends Command {

    public EnterCommand() {
        super("enter");
    }
    @Override
    public void run(Level level) {
        if (!level.getPlayer().moveTo(argumentString)) {
            System.out.println("Cannot move to the " + argumentString);
        }
    }
}
