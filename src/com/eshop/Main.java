package com.eshop;

import com.eshop.store.StoreManager;

public class Main {
    public static void main(String[] args) {
        StoreManager store = StoreManager.getInstance();
        store.start();
    }
}
