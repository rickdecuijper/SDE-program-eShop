package com.eshop.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements CartComponent {
    private List<CartComponent> items = new ArrayList<>();

    public void addItem(CartComponent item) {
        items.add(item);
    }

    public void removeItem(CartComponent item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CartComponent item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display() {
        System.out.println("Shopping Cart:");
        for (CartComponent item : items) {
            item.display();
        }
    }
}
