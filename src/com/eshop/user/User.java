package com.eshop.user;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // Called when product updates are published
    public void update(String productName, int stock) {
        System.out.println("Notification for " + name + ": Product '" + productName
                + "' now has stock " + stock);
    }

    public String getName() {
        return name;
    }
}
