package com.eshop.cart;

public class CartItem implements CartComponent {
    private String name;
    private double price;

    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.println("Product: " + name + " - $" + price);
    }
}
