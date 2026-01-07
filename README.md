# SDE-program-eShop
online shopping simulator
# Online Shop Simulation

## Overview
This project simulates a simple **online store** where users can browse products, manage shopping carts, and place orders. The program demonstrates multiple **design patterns** across creational, structural, and behavioral categories. It is implemented in **Java** and designed for clarity and modularity.  

**Team Members:**  
- Rick – contributed to Creational, Structural and Behavioral patterns, Singleton, Composite and Observer
- Bart – contributed to Creational, Structural and Behavioral patterns, Factory, Decorator and Command  

Both team members contributed roughly equally to the project development.

---

## Features
- Users can browse products by category.
- Users can add or remove items to/from their shopping cart.
- Products can have optional features like discounts or gift wrapping.
- Users receive notifications when product stock changes.
- Order checkout functionality confirms purchases.

---

## Design Patterns Implemented

### 1. Creational Patterns
**a) Singleton**  
- Class: `StoreManager`  
- Ensures that there is only **one instance of the store**, which manages all products and users.  
- Usage: All product and cart operations go through `StoreManager.get_instance()`.

**b) Factory Method**  
- Class: `ProductFactory`  
- Creates different types of products (`Book`, `Electronics`, `Clothing`) without specifying the exact class in the client code.  
- Usage: `ProductFactory.create_product(type, name, price)` returns the correct product instance.

---

### 2. Structural Patterns
**a) Composite**  
- Classes: `ShoppingCart`, `CartItem`  
- Allows treating individual products and groups of products in the cart **uniformly**.  
- Example: Cart can contain single items or bundles of items.

**b) Decorator**  
- Classes: `GiftWrapDecorator`, `DiscountDecorator`  
- Dynamically adds features to products, such as gift wrapping or applying discounts, **without modifying the original product class**.  

---

### 3. Behavioral Patterns
**a) Observer**  
- Classes: `User`, `Product`  
- Users subscribe to product updates. When product stock changes, **all subscribed users are notified automatically**.  

**b) Command**  
- Classes: `AddToCartCommand`, `RemoveFromCartCommand`, `CheckoutCommand`  
- Encapsulates user actions as objects. Commands can be queued or executed dynamically, allowing **flexible handling of operations**.
