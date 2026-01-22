package com.eshop.store;

import com.eshop.cart.CartItem;
import com.eshop.cart.ShoppingCart;
import com.eshop.decorator.DiscountDecorator;
import com.eshop.product.Products;
import com.eshop.product.ProductFactory;
import com.eshop.product.BookFactory;
import com.eshop.product.LaptopFactory;
import com.eshop.product.SmartphoneFactory;
import com.eshop.user.User;

import java.util.List;

public class StoreManager {

    private static volatile StoreManager instance;

    private StoreManager() {}

    public static StoreManager getInstance() {
        if (instance == null) {
            synchronized (StoreManager.class) {
                if (instance == null) {
                    instance = new StoreManager();
                }
            }
        }
        return instance;
    }

    // Start the store demo
    public void start() {

        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create factories (Factory Method pattern)
        ProductFactory bookFactory = new BookFactory();
        ProductFactory laptopFactory = new LaptopFactory();
        ProductFactory smartphoneFactory = new SmartphoneFactory();

        // Create products using factories
        Products book = bookFactory.createProduct(
                "Clean Code",
                39.99,
                20
        );

        Products laptop = laptopFactory.createProduct(
                "ThinkPad X1",
                1499.99,
                5
        );

        Products smartphone = smartphoneFactory.createProduct(
                "Galaxy S22",
                899.99,
                10
        );

        // Optional: store all products in a list
        List<Products> products = List.of(book, laptop, smartphone);

        // Apply decorator (20% discount on the laptop)
        Products discountedLaptop = new DiscountDecorator(laptop, 20);

        // Subscribe users to stock changes (Observer pattern)
        laptop.subscribe(alice);
        laptop.subscribe(bob);
        smartphone.subscribe(bob);

        // Alice's cart
        ShoppingCart cartAlice = new ShoppingCart();
        cartAlice.addItem(new CartItem(discountedLaptop.getName(), discountedLaptop.getPrice()));
        cartAlice.addItem(new CartItem(book.getName(), book.getPrice()));

        // Bob's cart
        ShoppingCart cartBob = new ShoppingCart();
        cartBob.addItem(new CartItem(smartphone.getName(), smartphone.getPrice()));

        // Merge carts into main checkout
        ShoppingCart mainCart = new ShoppingCart();
        mainCart.addItem(cartAlice);
        mainCart.addItem(cartBob);

        // Display results
        System.out.println("=== Shopping Carts ===");
        mainCart.display();
        System.out.printf("Total Price: $%.2f%n", mainCart.getPrice());

        // Update stock (triggers observer notifications)
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        smartphone.setStock(0);
    }
}
