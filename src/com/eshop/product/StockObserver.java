package com.eshop.product;

public interface StockObserver {
    void update(String productName, int stock);
}
