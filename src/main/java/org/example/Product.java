package org.example;


//This class is a POJO
//Plain ol' Java object
//No question asking, no files, no scanner, just product data
public class Product {
    private String sku;
    private String Name;
    private double price;
    private String category;
    //properties

    //constructor(s)

    public Product(String sku, String name, double price, String category) {
        this.sku = sku;
        Name = name;
        this.price = price;
        this.category = category;
    }

    //getters and setters

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
