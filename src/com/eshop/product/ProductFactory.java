package com.eshop.product;

public class ProductFactory {

    public static Product createProduct(ProductType type) {
        return switch (type) {
            case BOOK -> new Book("Harry Potter", 19.99, 100);
            case LAPTOP -> new Electronic("Laptop", 1499.99, 10);
            case SMARTPHONE -> new Electronic("SmartPhone", 1499.99, 10);
            case CLOTHING -> new Clothes("T-Shirt", 29.99, 50);
        };
    }

}
