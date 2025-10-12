package org.example;

import java.util.List;

//Want to ask questions? Ask them here
//Want to use the scanner? Use it here
//User input? Also here. You will have to call the file manager
//and the product class from here.
public class Main {
    public static void main(String[] args) {
        //1. Use the File Manager to load the file and create a list of products
        //2. Instantiate a shopping cart
        //3. Show the menu to the user
        //4. Based on what they select, use the right method
        //5. Use the shopping cart object you made to add and remove things from the shopping cart
        //6. The key thing is "How am I going to grab the specific item the user wants?"
    }

    public static void showMenu(){
        System.out.println("Here's the list of items");

    }

    //This method will find the product with the right sku
    //and return that product so later you can add it to the card
    public Product selectProductBySku(String sku){
        //for loops might help!
        List<Product> products = FileManager.getProducts();
        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                return product;
            }
        }
        return null;
    }

    public static void showAllProducts(){
        FileManager.getProducts();

    }

    public void searchProductsByName(String name){
        List<Product> products = FileManager.getProducts();
        boolean found = false;
        for (Product product : products){
            if (product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
                found = true;
            }
        if (!found) {
                System.out.println("Sorry we don't have it");
            }
        }

    }

    public void searchProductsByPriceRange(double minPrice, double maxPrice){
        //for (Product : Product){
            //Total = minPrice + Product
        //}

    }

    public void searchProductsByCategory(String category){
        //for (product.getCategory().equalsIgnoreCase(category)) {
            //return product;
        }

    }
}