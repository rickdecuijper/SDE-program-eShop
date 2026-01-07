package com.eshop;

import com.eshop.store.StoreManager;

public class Main {
    public static void main(String[] args) {
        // Start the store demo via singleton
        StoreManager.getInstance().start();
    }
}
