package entity;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String category;

    public Product() {
    }
    public Product(int productId, String productName, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
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

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setName(String productName) {
        this.productName = productName;
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
        return "Product [ID: " + productId + ", Name: " + productName + ", Price: $" + price + ", Category: " + category + "]";
    }
}
