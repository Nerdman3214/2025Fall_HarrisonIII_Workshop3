package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//You should have two methods here, one to return a list of
//products, another to take a product and write it to the file
//No menus, no scanner, no questions, just read from the file
//write to the file. That's it.

public class FileManager {

    private static final String FILE_PATH = "C:/Bootcamp/Workshop/2025Fall_HarrisonIII_Workshop3/OnlineStoreTemplate/src/main/java/org/example/products.csv";

    //  Reads all products from the CSV file
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            // Optional: skip a header line if one exists
            // br.readLine();

            String line = br.readLine(); // skip the header line first

            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                String sku = values[0];
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                String category = values[3];



                products.add(new Product(sku, name, price, category));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    //  Appends a single Product to the CSV file
    public static void writeProduct(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = product.getSku() + "\\|" + product.getName() + "\\|" + product.getPrice() + "\\|" + product.getCategory();
            bw.newLine(); // Moves to the next line before writing
            bw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Optional main() to test reading/writing
    //public static void main(String[] args) {
        // Example: Add a product
        //writeProduct(new Product("001", "Apple", 1.29, "Fruit"));

        // Example: Load all products and print them
        //List<Product> products = getProducts();
        //System.out.println("Loaded products: " + products.size());

        //for (Product p : products) {
            //System.out.println(p);
        //}
    //}
}