package com.eshop.product;

import com.eshop.user.User;

public interface Products {

    String getName();
    double getPrice();
    int getStock();

    void setStock(int stock);

    // Observer support (based on your StoreManager usage)
    void subscribe(User user);
    void unsubscribe(User user);
}

