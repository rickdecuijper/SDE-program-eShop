package com.eshop.command;

import com.eshop.product.Product;
import com.eshop.cart.Cart;

/**
 * Command to add a product to the cart.
 */
public class AddToCartCommand implements Command {

    private Cart cart;
    private Product product;

    public AddToCartCommand(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    @Override
    public void execute() {
        cart.addProduct(product);
        System.out.println(product.getName() + " added to cart.");
    }
}
