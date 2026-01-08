package com.eshop.decorator;

import com.eshop.product.Product;

/**
 * Base Decorator class extending Product.
 * Wraps another Product and delegates behavior.
 */
public abstract class ProductDecorator extends Product {

    protected Product wrappedProduct;

    public ProductDecorator(Product product) {
        super(product.getName(), product.getPrice(), product.getStock());
        this.wrappedProduct = product;
    }

    @Override
    public String getName() {
        return wrappedProduct.getName();
    }

    @Override
    public double getPrice() {
        return wrappedProduct.getPrice();
    }

    @Override
    public int getStock() {
        return wrappedProduct.getStock();
    }
}
