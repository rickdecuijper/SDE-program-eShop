package com.eshop.product;

public class SmartphoneFactory extends ProductFactory {

    @Override
    public Products createProduct(String name, double price, int stock) {
        return new Smartphone(name, price, stock);
    }
}
