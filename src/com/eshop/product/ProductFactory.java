package com.eshop.product;

public class ProductFactory {

    public static Product createProduct(ProductType type) {
        return switch (type) {
            case BOOK -> new Book();
            case ELECTRONICS -> new Electronics();
            case CLOTHING -> new Clothing();
        };
    }
}
