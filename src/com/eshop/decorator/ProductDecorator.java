package com.eshop.decorator;

import com.eshop.product.Products;
import com.eshop.user.User;

/**
 * Base decorator for Products.
 * Implements Products so decorators are interchangeable with products.
 */
public abstract class ProductDecorator implements Products {

    protected final Products wrappedProduct;

    protected ProductDecorator(Products product) {
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

    @Override
    public void setStock(int stock) {
        wrappedProduct.setStock(stock);
    }

    @Override
    public void subscribe(User user) {
        wrappedProduct.subscribe(user);
    }

    @Override
    public void unsubscribe(User user) {
        wrappedProduct.unsubscribe(user);
    }
}
