package com.eshop.product;

//public class ProductFactory {
//
//    public static Product createProduct(ProductType type) {
//        return switch (type) {
//            case BOOK -> new Book("Harry Potter", 19.99, 100);
//            case LAPTOP -> new Electronic("Laptop", 1499.99, 10);
//            case SMARTPHONE -> new Electronic("SmartPhone", 1499.99, 10);
//            case CLOTHING -> new Clothes("T-Shirt", 29.99, 50);
//        };
//    }
//
//}

abstract class ProductFactory extends Product {
    public ProductFactory(String name, double price, int stock) {
        super(name, price, stock);
    }

    public abstract function createProduct(String name, double price, int stock);

    public function fire($id) {
        $employee = $this->createProduct(name);
        $employee->paySalary();
        $employee->dismiss();
    }
}
