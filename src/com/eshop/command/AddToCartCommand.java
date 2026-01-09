package com.eshop.command;

import com.eshop.cart.Cart;
import com.eshop.product.Product;

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
