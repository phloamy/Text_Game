public abstract class Command {

    private String name;
    protected String argumentString;

    public Command(String name) {
        this.name = name;
    }

    private void init(String argumentString) {
        this.argumentString = argumentString;
    }

    public boolean matches(String input) {
        String[] split = input.split(" ");
        if (split[0].equals(name)) {
            init(input.substring(split[0].length()).trim());
            return true;
        }
        return false;
    }

    public abstract void run(Level level);

    public String getCommandWord() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
