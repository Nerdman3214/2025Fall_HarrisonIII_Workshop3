package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCartBySku(String sku) {
        cart.removeIf(p -> p.getSku().equalsIgnoreCase(sku));
    }

    public double getCartTotal() {
        double total = 0.0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }

    public List<Product> getCartItems() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public void printCartContents() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("=== Your Cart ===");
        for (Product p : cart) {
            System.out.println(p);
        }
        System.out.printf("Total: $%.2f%n", getCartTotal());
    }
}
