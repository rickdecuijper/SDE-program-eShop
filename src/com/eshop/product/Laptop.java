package com.eshop.product;

import com.eshop.user.User;

import java.util.ArrayList;
import java.util.List;

public class Laptop implements Products {

    private final String name;
    private final double price;
    private int stock;
    private final List<User> subscribers = new ArrayList<>();

    public Laptop(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
        notifySubscribers();
    }

    @Override
    public void subscribe(User user) {
        subscribers.add(user);
    }

    @Override
    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    private void notifySubscribers() {
        for (User user : subscribers) {
            user.update(name, stock);
        }
    }
}
