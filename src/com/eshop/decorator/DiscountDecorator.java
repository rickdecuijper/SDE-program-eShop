package com.eshop.decorator;

import com.eshop.product.Product;

/**
 * Applies a percentage discount to the product price.
 */
public class DiscountDecorator extends ProductDecorator {

    private final double discountPercent;

    public DiscountDecorator(Product product, double discountPercent) {
        super(product);
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        double original = wrappedProduct.getPrice();
        double discountAmount = original * (discountPercent / 100);
        double newPrice = original - discountAmount;
        return Math.max(newPrice, 0);
    }

    @Override
    public String getName() {
        return wrappedProduct.getName() + " (" + discountPercent + "% off)";
    }
}
