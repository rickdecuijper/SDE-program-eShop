package com.eshop.product;

public abstract class ProductFactory {
    public abstract Product createProduct(String name, double price, int stock);

    public static class SmartphoneFactory extends ProductFactory {
        @Override
        public Product createProduct(String name, double price, int stock) {
            return new Smartphone(name, price, stock);
        }
    }

    public static class LaptopFactory extends ProductFactory {
        @Override
        public Product createProduct(String name, double price, int stock) {
            return new Laptop(name, price, stock);
        }
    }

    public static class BookFactory extends ProductFactory {
        @Override
        public Product createProduct(String name, double price, int stock) {
            return new Book(name, price, stock);
        }
    }
}
