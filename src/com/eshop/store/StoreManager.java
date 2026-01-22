package com.eshop.store;

import com.eshop.cart.CartItem;
import com.eshop.cart.ShoppingCart;
import com.eshop.decorator.DiscountDecorator;
import com.eshop.product.Product;
import com.eshop.product.ProductFactory;
import com.eshop.product.ProductType;
import com.eshop.user.User;

import java.util.ArrayList;
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

        // Create users (Observers)
        User alice = new User("Alice");
        User bob = new User("Bob");

        Product laptop = new ProductFactory.LaptopFactory().createProduct("MacBook", 1999.99, 5);
        Product book = new ProductFactory.BookFactory().createProduct("Java Book", 49.99, 20);
        Product smartphone = new ProductFactory.SmartphoneFactory().createProduct("Pixel", 799.99, 10);

        // Add them to the list in the same order as your enum
        List<Product> products = new ArrayList<>();
        products.add(laptop);       // index 0 -> LAPTOP
        products.add(book);         // index 1 -> BOOK
        products.add(smartphone);   // index 2 -> SMARTPHONE

        // Apply Decorator (20% discount on laptop)
        Product discountedLaptop = new DiscountDecorator(laptop, 20);

        // Subscribe users to stock updates (Observer pattern)
        laptop.subscribe(alice);
        laptop.subscribe(bob);
        smartphone.subscribe(bob);

        // Alice's shopping cart
        ShoppingCart cartAlice = new ShoppingCart();
        cartAlice.addItem(new CartItem(discountedLaptop.getName(), discountedLaptop.getPrice()));
        cartAlice.addItem(new CartItem(book.getName(), book.getPrice()));

        // Bob's shopping cart
        ShoppingCart cartBob = new ShoppingCart();
        cartBob.addItem(new CartItem(smartphone.getName(), smartphone.getPrice()));

        // Combine carts using Composite pattern
        ShoppingCart mainCart = new ShoppingCart();
        mainCart.addItem(cartAlice);
        mainCart.addItem(cartBob);

        // Display cart contents
        System.out.println("=== Shopping Carts ===");
        mainCart.display();
        System.out.printf("Total Price: $%.2f%n", mainCart.getPrice());

        // Update stock (triggers Observer notifications)
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        smartphone.setStock(0);
    }
}
