package com.eshop.product;

import com.eshop.user.User;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private int stock;

    // Observer list
    private List<User> subscribers = new ArrayList<>();

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Subscribe a user
    public void subscribe(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
        }
    }

    // Unsubscribe a user
    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    // Notify all subscribers
    private void notifyUsers() {
        for (User user : subscribers) {
            user.update(name, stock);
        }
    }

    // Change stock and notify subscribers
    public void setStock(int stock) {
        this.stock = stock;
        notifyUsers();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
