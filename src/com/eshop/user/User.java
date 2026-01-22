package com.eshop.user;

import com.eshop.product.StockObserver;

public class User implements StockObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // Called when product updates are published
    @Override
    public void update(String productName, int stock) {
        System.out.println(
            "Notification for " + name +
            ": Product '" + productName +
            "' now has stock " + stock
        );
    }

    public String getName() {
        return name;
    }
}
