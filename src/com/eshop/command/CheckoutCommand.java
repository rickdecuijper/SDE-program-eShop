package com.eshop.command;

import com.eshop.cart.Cart;

/**
 * Command to check out and complete purchase.
 */
public class CheckoutCommand implements Command {

    private Cart cart;

    public CheckoutCommand(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        double total = cart.getTotal();
        System.out.println("Checkout complete! Total: €" + total);
        cart.clear();
    }
}
