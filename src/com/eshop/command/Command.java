package com.eshop.command;

/**
 * Command interface defining a single action that can be executed.
 *
 * Each concrete command encapsulates a user action,
 * such as adding or removing an item from the cart or checking out.
 */
public interface Command {
    void execute();
}
