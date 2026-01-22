package com.eshop.product;

public abstract class ProductFactory {

    public abstract Products createProduct(String name, double price, int stock);
}
