package org.example;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {

    public static void generateReceipt(List<Product> items, double subtotal, double tax, double total) {
        String fileName = "receipt_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== Online Store Receipt ===\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("----------------------------------\n");

            for (Product p : items) {
                writer.write(p.getName() + " - $" + p.getPrice() + "\n");
            }

            writer.write("----------------------------------\n");
            writer.write(String.format("Subtotal: $%.2f\n", subtotal));
            writer.write(String.format("Tax (8.25%%): $%.2f\n", tax));
            writer.write(String.format("Total: $%.2f\n", total));
            writer.write("----------------------------------\n");
            writer.write("Thank you for shopping with us!\n");

            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
