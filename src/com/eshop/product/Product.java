package com.eshop.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private int stock;

    // Observer list (interface, not User)
    private List<StockObserver> subscribers = new ArrayList<>();

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Subscribe observer
    public void subscribe(StockObserver observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
        }
    }

    // Unsubscribe observer
    public void unsubscribe(StockObserver observer) {
        subscribers.remove(observer);
    }

    // Notify all observers
    private void notifyObservers() {
        for (StockObserver observer : subscribers) {
            observer.update(name, stock);
        }
    }

    // Change stock and notify observers
    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers();
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
