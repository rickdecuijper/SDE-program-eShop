package com.eshop.decorator;

import com.eshop.product.Product;

/**
 * Adds a fixed gift-wrapping fee to the product.
 */
public class GiftWrapDecorator extends ProductDecorator {

    private static final double WRAP_FEE = 2.50;

    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return wrappedProduct.getPrice() + WRAP_FEE;
    }

    @Override
    public String getName() {
        return wrappedProduct.getName() + " (Gift Wrapped)";
    }
}
