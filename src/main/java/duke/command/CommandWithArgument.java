package duke.command;

import java.util.Arrays;

/**
 * The CommandWithArgument class extends the Command class by allowing the supported command to have an argument.
 */
public class CommandWithArgument extends Command {

    /* Name of the argument */
    private String argumentName;

    /**
     * Instantiates a new supported command that has an argument.
     *
     * @param command      Command to support.
     * @param argumentName Name of the argument.
     */
    public CommandWithArgument(String command, String argumentName) {
        super(command);
        this.argumentName = argumentName;
    }

    public String getArgumentName() {
        return argumentName;
    }

    /**
     * Returns the command syntax of the command.
     *
     * @return Command syntax.
     */
    @Override
    public String getUsage() {
        return String.format("%s <%s>", super.getCommand(), argumentName);
    }

    /**
     * Checks if the given input is a valid command.
     *
     * @param inputLine Raw input line to check.
     * @return True if the input is valid.
     */
    @Override
    public boolean isValidCommandLine(String inputLine) {
        String commandLine = inputLine.strip();
        String[] tokens = commandLine.split(" ", -1);
        String argumentValue = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

        boolean isStartWithCommand = commandLine.startsWith(super.getCommand() + " ");
        boolean isNonEmptyArgument = argumentValue.length() > 0;

        return isStartWithCommand && isNonEmptyArgument;
    }

    /**
     * Returns the parsed values from the argument.
     *
     * @param inputLine Raw input line to parse.
     * @return List of parsed values.
     */
    @Override
    public String[] parseCommand(String inputLine) {
        String commandLine = inputLine.strip();
        String[] tokens = commandLine.split(" ", -1);
        String argumentValue = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

        return new String[] {argumentValue};
    }
}