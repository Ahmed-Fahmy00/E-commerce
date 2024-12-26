package Backend.entity;

import Backend.entity.Enum.Brand;

public class Product {
    private static int IdCounter = 1;
    private int productId;
    private String productName;
    private double price;
    private String category;
    private Brand brand;
    private double rate;

    public Product() {
        this.productId = IdCounter++;
    }
    public Product(String productName, double price, String category, Brand brand, double rate) {
        this.productId = IdCounter++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.rate = rate;
    }

    public int getProductId() {
        return productId;
    }
    public String getName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public Brand getBrand() {
        return brand;
    }
    public double getRate() { return rate;}


    public void setName(String productName) {
        this.productName = productName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public void setRate(double rate) {this.rate = rate;}

    @Override
    public String toString() {
        return "Product [ID: " + productId +
                ", Name: " + productName +
                ", Price: $" + String.format("%.2f", price) +
                ", Category: " + category +
                ", Brand: " + (brand != null ? brand.toString() : "N/A") +
                ", Rate: " + String.format("%.1f", rate) + "]";
    }
}
