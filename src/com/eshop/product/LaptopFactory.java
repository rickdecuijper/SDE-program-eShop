package com.eshop.product;

public class LaptopFactory extends ProductFactory {

    @Override
    public Products createProduct(String name, double price, int stock) {
        return new Laptop(name, price, stock);
    }
}
