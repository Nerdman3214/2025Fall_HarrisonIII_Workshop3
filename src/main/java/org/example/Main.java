package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Load products from FileManager
        List<Product> products = FileManager.getProducts();

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    showAllProducts(products);
                    System.out.println("Loaded products: " + products.size());
                    break;
                case 2:
                    System.out.print("Enter SKU to add to cart: ");
                    String addSku = scanner.nextLine();
                    Product addProduct = selectProductBySku(products, addSku);
                    if (addProduct != null) {
                        cart.addToCart(addProduct);
                        System.out.println(addProduct.getName() + " added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter SKU to remove from cart: ");
                    String removeSku = scanner.nextLine();
                    cart.removeFromCartBySku(removeSku);
                    break;
                case 4:
                    cart.printCartContents();
                    break;
                case 5:
                    System.out.print("Enter product name to search: ");
                    String nameSearch = scanner.nextLine();
                    searchProductsByName(products, nameSearch);
                    break;
                case 6:
                    System.out.print("Enter category to search: ");
                    String categorySearch = scanner.nextLine();
                    searchProductsByCategory(products, categorySearch);
                    break;
                case 7:
                    System.out.print("Enter min price: ");
                    double min = scanner.nextDouble();
                    System.out.print("Enter max price: ");
                    double max = scanner.nextDouble();
                    scanner.nextLine(); // clear buffer
                    searchProductsByPriceRange(products, min, max);
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                case 9:
                    checkout(cart);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // ====== Menu ======
    public static void showMenu() {
        System.out.println("\n=== Shopping Menu ===");
        System.out.println("1) Show all products");
        System.out.println("2) Add product to cart");
        System.out.println("3) Remove product from cart");
        System.out.println("4) View cart");
        System.out.println("5) Search by name");
        System.out.println("6) Search by category");
        System.out.println("7) Search by price range");
        System.out.println("8) Exit");
        System.out.println("9) Checkout and generate receipt");
        System.out.print("Choose an option: ");
    }

    // ====== Product Display ======
    public static void showAllProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);

        }
    }

    // ====== Select Product ======
    public static Product selectProductBySku(List<Product> products, String sku) {
        for (Product p : products) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    // ====== Search Methods ======
    public static void searchProductsByName(List<Product> products, String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found with that name.");
        }
    }

    public static void searchProductsByCategory(List<Product> products, String category) {
        boolean found = false;
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }

    public static void searchProductsByPriceRange(List<Product> products, double min, double max) {
        boolean found = false;
        for (Product p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in this price range.");
        }
    } // ✅ Properly close this method before defining checkout()

    // ====== Checkout ======
    public static void checkout(ShoppingCart cart) {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        double subtotal = cart.getCartTotal();
        double taxRate = 0.0825;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (8.25%%): $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Proceed with checkout? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptManager.generateReceipt(cart.getCartItems(), subtotal, tax, total);
            cart.clearCart();
            System.out.println("Checkout complete! Thank you for your purchase.");
        } else {
            System.out.println("Checkout canceled.");
        }
    }
}
