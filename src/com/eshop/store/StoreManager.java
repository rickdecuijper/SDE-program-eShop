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
        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create all products from ProductType enum
        List<Product> products = new ArrayList<>();
        for (ProductType type : ProductType.values()) {
            products.add(ProductFactory.createProduct(type));
        }

        // Pick items
        Product laptop = products.get(ProductType.LAPTOP.ordinal());
        Product book = products.get(ProductType.BOOK.ordinal());
        Product smartphone = products.get(ProductType.SMARTPHONE.ordinal());

        //  Apply decorator (20% discount on the laptop!)
        Product discountedLaptop = new DiscountDecorator(laptop, 20);

        // Subscribe users to stock changes
        laptop.subscribe(alice);
        laptop.subscribe(bob);

        smartphone.subscribe(bob);

        // Alice's cart uses the discounted price
        ShoppingCart cartAlice = new ShoppingCart();
        cartAlice.addItem(new CartItem(discountedLaptop.getName(), discountedLaptop.getPrice()));
        cartAlice.addItem(new CartItem(book.getName(), book.getPrice()));

        // Bob buys a smartphone
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

        // Change stock → triggers observer notifications
        System.out.println("\n=== Updating Stock ===");
        laptop.setStock(5);
        smartphone.setStock(0);
    }
}
