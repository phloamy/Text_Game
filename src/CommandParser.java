import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private List<Command> commands;

    public CommandParser() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command c) {
        commands.add(c);
    }

    public Command parseCommand(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                return command;
            }
        }

        System.out.println("That command was invalid. You can: ");
        for (Command command : commands) {
            System.out.println(command);
        }
        return null;
    }
}
