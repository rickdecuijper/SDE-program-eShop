package com.eshop.product;

/**
 * This enum defines the list of product types
 * that the ProductFactory can create.
 *
 * Instead of typing raw strings, we use constant values.
 * This prevents bugs and makes the code easier to maintain.
 */
public enum ProductType {
    BOOK,
    CLOTHING,
    LAPTOP,
    SMARTPHONE,
}
