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

    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }
}
