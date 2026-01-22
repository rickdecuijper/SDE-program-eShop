package com.eshop.store;

import com.eshop.cart.CartItem;
import com.eshop.cart.ShoppingCart;
import com.eshop.command.AddToCartCommand;
import com.eshop.command.CheckoutCommand;
import com.eshop.command.Command;
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

        // Create products using Factory Method
        List<Product> products = new ArrayList<>();
        for (ProductType type : ProductType.values()) {
            products.add(ProductFactory.createProduct(type));
        }

        // Select products
        Product laptop = products.get(ProductType.LAPTOP.ordinal());
        Product book = products.get(ProductType.BOOK.ordinal());
        Product smartphone = products.get(ProductType.SMARTPHONE.ordinal());

        // Apply Decorator (20% discount)
        Product discountedLaptop = new DiscountDecorator(laptop, 20);

        // Subscribe users (Observer pattern)
        laptop.subscribe(alice);
        laptop.subscribe(bob);
        smartphone.subscribe(bob);

        // Alice's cart
        ShoppingCart cartAlice = new ShoppingCart();

        Command addLaptopToAlice =
                new AddToCartCommand(cartAlice,
                        new CartItem(discountedLaptop.getName(), discountedLaptop.getPrice()));

        Command addBookToAlice =
                new AddToCartCommand(cartAlice,
                        new CartItem(book.getName(), book.getPrice()));

        addLaptopToAlice.execute();
        addBookToAlice.execute();

        // Bob's cart
        ShoppingCart cartBob = new ShoppingCart();

        Command addPhoneToBob =
                new AddToCartCommand(cartBob,
                        new CartItem(smartphone.getName(), smartphone.getPrice()));

        addPhoneToBob.execute();

        // Combine carts (Composite)
        ShoppingCart mainCart = new ShoppingCart();
        mainCart.addItem(cartAlice);
        mainCart.addItem(cartBob);

        // Display carts
        System.out.println("=== Shopping Carts ===");
        mainCart.display();
        System.out.printf("Total Price: $%.2f%n", mainCart.getPrice());

        // Checkout using Command pattern
        Command checkout = new CheckoutCommand(mainCart);
        checkout.execute();

        // Update stock (Observer notifications)
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        smartphone.setStock(0);
    }
}
