package com.eshop.product;

public class BookFactory extends ProductFactory {

    @Override
    public Products createProduct(String name, double price, int stock) {
        return new Book(name, price, stock);
    }
}
