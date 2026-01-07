# SDE-program-eShop  
Online Shopping Simulator

## Overview
This project simulates a simple **online store** where users can browse products, manage shopping carts, and place orders. The program demonstrates multiple **software design patterns** across creational, structural, and behavioral categories. It is implemented in **Java** and designed for clarity and modularity.

**Team Members:**  
- Rick – contributed to creational, structural, and behavioral patterns (Singleton, Composite, Observer)  
- Bart – contributed to creational, structural, and behavioral patterns (Factory Method, Decorator, Command)  

Both team members contributed roughly equally to the project development.

---

## Features
- Browse products by category  
- Add and remove items from a shopping cart  
- Apply optional product features such as discounts or gift wrapping  
- Receive notifications when product stock changes  
- Checkout and confirm orders  

---

## Project Structure

SDE-program-eShop/

│

├── src/

│ &emsp; ├── com/

│ &emsp;&emsp; ├── eshop/

│ &emsp;&emsp;&emsp; ├── Main.java

│

│ &emsp;&emsp;&emsp; ├── store/

│ &emsp;&emsp;&emsp;&emsp; │ └── StoreManager.java

│

│ &emsp;&emsp;&emsp; ├── product/

│ &emsp;&emsp;&emsp;&emsp; │ ├── Product.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── Book.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── Electronics.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── Clothing.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── ProductFactory.java

│ &emsp;&emsp;&emsp;&emsp; │ └── StockObserver.java

│
│ &emsp;&emsp;&emsp; ├── user/

│ &emsp;&emsp;&emsp;&emsp; │ └── User.java

│
│ &emsp;&emsp;&emsp; ├── cart/

│ &emsp;&emsp;&emsp;&emsp; │ ├── CartComponent.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── CartItem.java

│ &emsp;&emsp;&emsp;&emsp; │ └── ShoppingCart.java

│

│ &emsp;&emsp;&emsp; ├── decorator/

│ &emsp;&emsp;&emsp;&emsp; │ ├── ProductDecorator.java

│ &emsp;&emsp;&emsp;&emsp; │ ├── GiftWrapDecorator.java

│ &emsp;&emsp;&emsp;&emsp; │ └── DiscountDecorator.java

│
│ &emsp;&emsp;&emsp; └── command/

│ &emsp;&emsp;&emsp;&emsp; ├── Command.java

│ &emsp;&emsp;&emsp;&emsp; ├── AddToCartCommand.java

│ &emsp;&emsp;&emsp;&emsp; ├── RemoveFromCartCommand.java

│ &emsp;&emsp;&emsp;&emsp; └── CheckoutCommand.java

│

├── README.md

└── .gitignore


### Structure Rationale
The project uses a **simple and intentional package structure** . All source code is located under `src/`, and the base package `com.eshop` follows standard Java naming conventions while avoiding the default package.

Subpackages are organized by **responsibility and design pattern**, making it easy to identify where each pattern is implemented. This improves readability and directly reflects the architectural decisions described in this document.

The commonly used `src/main/java` structure was intentionally not used. The project does not rely on build tools such as Maven or Gradle and does not include separate test or resource directories. Omitting unnecessary directory levels keeps the project lightweight and easier to navigate without sacrificing proper organization.

---

## Design Patterns Implemented

### 1. Creational Patterns

**Singleton**  
- Class: `StoreManager`  
- Ensures that only one instance of the store exists and centralizes access to products, users, and carts.  
- All store operations are accessed via `StoreManager.getInstance()`.

**Factory Method**  
- Class: `ProductFactory`  
- Creates different product types (`Book`, `Electronics`, `Clothing`) without exposing concrete class creation to the client.  
- Simplifies product creation and supports extensibility.

---

### 2. Structural Patterns

**Composite**  
- Classes: `ShoppingCart`, `CartItem`  
- Allows individual products and groups of products to be treated uniformly within the shopping cart.

**Decorator**  
- Classes: `GiftWrapDecorator`, `DiscountDecorator`  
- Adds optional behavior to products dynamically without modifying existing product classes.

---

### 3. Behavioral Patterns

**Observer**  
- Classes: `Product`, `User`  
- Users can subscribe to product updates and are automatically notified when stock levels change.

**Command**  
- Classes: `AddToCartCommand`, `RemoveFromCartCommand`, `CheckoutCommand`  
- Encapsulates user actions as command objects, allowing flexible execution and extension of user operations.

---

## Summary
This project demonstrates the practical application of multiple design patterns in a cohesive and well-structured Java application. The chosen structure prioritizes clarity, maintainability, and academic suitability while remaining flexible for future extensions.
