package com.eshop.store;

import com.eshop.cart.CartItem;
import com.eshop.cart.ShoppingCart;
import com.eshop.command.AddToCartCommand;
import com.eshop.command.CheckoutCommand;
import com.eshop.command.Command;
import com.eshop.decorator.DiscountDecorator;
import com.eshop.decorator.GiftWrapDecorator;
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

        // --- Create users (Observers) ---
        User alice = new User("Alice");
        User bob = new User("Bob");

        // --- Create factories (Factory Method) ---
        ProductFactory bookFactory = new BookFactory();
        ProductFactory laptopFactory = new LaptopFactory();
        ProductFactory smartphoneFactory = new SmartphoneFactory();

        // --- Create products ---
        Products book = bookFactory.createProduct("Clean Code", 39.99, 20);
        Products laptop = laptopFactory.createProduct("ThinkPad X1", 1499.99, 5);
        Products smartphone = smartphoneFactory.createProduct("Galaxy S22", 899.99, 10);

        List<Products> products = List.of(book, laptop, smartphone);

        // --- Apply decorators ---
        Products discountedLaptop = new DiscountDecorator(laptop, 20);
        Products giftWrappedBook = new GiftWrapDecorator(book);

        // --- Subscribe users (Observer pattern) ---
        laptop.subscribe(alice);
        laptop.subscribe(bob);
        smartphone.subscribe(bob);

        // --- Alice's cart ---
        ShoppingCart cartAlice = new ShoppingCart();

        Command addLaptopToAlice =
                new AddToCartCommand(cartAlice,
                        new CartItem(discountedLaptop.getName(), discountedLaptop.getPrice()));

        Command addBookToAlice =
                new AddToCartCommand(cartAlice,
                        new CartItem(giftWrappedBook.getName(), giftWrappedBook.getPrice()));

        addLaptopToAlice.execute();
        addBookToAlice.execute();

        // --- Bob's cart ---
        ShoppingCart cartBob = new ShoppingCart();

        Command addPhoneToBob =
                new AddToCartCommand(cartBob,
                        new CartItem(smartphone.getName(), smartphone.getPrice()));

        addPhoneToBob.execute();

        // --- Combine carts (Composite pattern) ---
        ShoppingCart mainCart = new ShoppingCart();
        mainCart.addItem(cartAlice);
        mainCart.addItem(cartBob);

        // --- Display carts ---
        System.out.println("=== Shopping Carts ===");
        mainCart.display();
        System.out.printf("Total Price: $%.2f%n", mainCart.getPrice());

        // --- Checkout using Command pattern ---
        Command checkout = new CheckoutCommand(mainCart);
        checkout.execute();

        // --- Update stock (Observer notifications) ---
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        smartphone.setStock(0);
    }
}
