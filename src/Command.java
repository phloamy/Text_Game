public abstract class Command {

    private String name;
    private int numArguments;

    public Command(String name, int numArguments) {
        this.name = name;
        this.numArguments = numArguments;
    }

    public boolean matches(String input) {
        String[] split = input.split(" ");
        return (split.length == numArguments + 1 && split[0].equals(name));
    }

    public abstract void run(String input, Player player);

    @Override
    public String toString() {
        return name;
    }
}
