package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//You should have two methods here, one to return a list of
//products, another to take a product and write it to the file
//No menus, no scanner, no questions, just read from the file
//write to the file. That's it.
public class FileManager {
    public static void readFile() {
        String filePath = "products.csv"; // Replace with your file path
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);// Split by comma
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    public static void writeFile() {
        String filePath = "products.csv";
        String csvData = "Name,Age,Location";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(csvData); // Write data to the file
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
    //The reason these are static is so that you can directly
    //call the method like FileManager.getProducts()
    //Notice the capital F
    public static List<Product> getProducts(){
        List<String[]> data = new ArrayList<>();
        //You are going to write code to read the products
        //from the file, put them in a list and return them
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        return new ArrayList<>();
    }

    public static void writeProduct(Product product){
        //This method you will take the product that is being
        //put in to this method, take its data and write it to the file
    }
}
