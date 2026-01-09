package com.eshop.command;

import com.eshop.cart.Cart;
import com.eshop.product.Product;

/**
 * Command to remove a product from the cart.
 */
public class RemoveFromCartCommand implements Command {

    private Cart cart;
    private Product product;

    public RemoveFromCartCommand(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    @Override
    public void execute() {
        cart.removeProduct(product);
        System.out.println(product.getName() + " removed from cart.");
    }
}
