package com.eshop.store;

import com.eshop.cart.CartItem;
import com.eshop.cart.ShoppingCart;
import com.eshop.command.Command;
import com.eshop.command.CommandInvoker;
import com.eshop.product.Product;
import com.eshop.user.User;

public class StoreManager {

    private static volatile StoreManager instance;
    private CommandInvoker invoker = new CommandInvoker(); // Command invoker

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

    /**
     * Executes a command through the invoker
     *
     * @param command the command to execute
     */
    public void executeCommand(Command command) {
        invoker.executeCommand(command);
    }

    /**
     * Start the store demo
     */
    public void start() {
        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create products
        Product laptop = new Product("Laptop", 1200.0, 10);
        Product phone = new Product("Smartphone", 800.0, 15);
        Product headphones = new Product("Headphones", 150.0, 20);

        // Subscribe users to products
        laptop.subscribe(alice);
        laptop.subscribe(bob);
        phone.subscribe(bob);

        // Create shopping carts
        ShoppingCart cartAlice = new ShoppingCart();
        cartAlice.addItem(new CartItem("Laptop", laptop.getPrice()));
        cartAlice.addItem(new CartItem("Headphones", headphones.getPrice()));

        ShoppingCart cartBob = new ShoppingCart();
        cartBob.addItem(new CartItem("Smartphone", phone.getPrice()));

        ShoppingCart mainCart = new ShoppingCart();
        mainCart.addItem(cartAlice);
        mainCart.addItem(cartBob);

        // Display carts
        System.out.println("=== Shopping Carts ===");
        mainCart.display();
        System.out.println("Total Price: $" + mainCart.getPrice());

        // Update stock to trigger observer notifications
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        phone.setStock(0);
    }
}
