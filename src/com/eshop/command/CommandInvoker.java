package com.eshop.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker stores commands and executes them in order.
 *
 * You can extend this later to support undo/redo if desired.
 */
public class CommandInvoker {

    private List<Command> history = new ArrayList<>();

    /**
     * Executes a command and stores it in history.
     *
     * @param command the command to execute
     */
    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    /**
     * Returns the list of executed commands.
     *
     * @return history of commands
     */
    public List<Command> getHistory() {
        return new ArrayList<>(history);
    }
}
