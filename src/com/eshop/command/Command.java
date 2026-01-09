package com.eshop.command;

/**
 * Command interface defining a single action that can be executed.
 *
 * Each concrete command encapsulates a user action,
 * such as adding an item to the cart.
 */
public interface Command {
    void execute();
}
