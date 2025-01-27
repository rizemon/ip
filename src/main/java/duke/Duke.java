package duke;

import duke.command.CommandExecutor;
import duke.ui.Ui;

/**
 * The Duke application serves to aid users in the management of their tasks.
 */
public class Duke {

    private CommandExecutor commandExecutor;
    private Ui ui;

    /**
     * Instantiates the Duke application.
     */
    public Duke() {
        commandExecutor = new CommandExecutor();
        ui = new Ui();
    }

    /**
     * Starts the Duke application.
     */
    public void run() {
        ui.printWelcomeMessage();

        do {
            String rawLine = ui.readInput();
            commandExecutor.execute(rawLine);
        } while (!commandExecutor.isExit());

        ui.printByeMessage();
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
