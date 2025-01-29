package tests;

import Backend.dao.CategoryDAO;
import Backend.entity.Category;
import Backend.entity.Enum.Brand;
import Backend.entity.Order;
import Backend.entity.Product;

import java.util.ArrayList;

public class Ordertest {


    public static void makeOrders() {
        Category category1 = new Category("Apple");
        Category category2 = new Category("Tablets");
        Category category3 = new Category("Laptops");
        Category category4 = new Category("PC");
        Category category5 = new Category("Accessories");

        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.add(category1);
        categoryDAO.add(category2);
        categoryDAO.add(category3);
        categoryDAO.add(category4);
        categoryDAO.add(category5);

        // Create the first ArrayList of products
        ArrayList<Product> apple = new ArrayList<>();
        apple.add(new Product("Iphone 12", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("Iphone 13", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("Iphone 14", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("Iphone 16", 999.99, category1, Brand.Apple, 4.5));
        Order order1=new Order();
        order1.setProducts(apple);

        // Create the second ArrayList of products
        ArrayList<Product> samsung = new ArrayList<>();
        samsung.add(new Product("Galaxy S24 Ultra", 1999.99, category1, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Fold 6", 699.99, category2, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Z Flip 6", 699.99, category2, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Tab S9 FE+", 699.99, category2, Brand.Samsung, 4.5));
        samsung.add(new Product("Samsung Buds 2", 99.99, category5, Brand.Samsung, 4.5));
        Order order2 =new Order();
        order2.setProducts(samsung);

        // Create the third ArrayList of products
        ArrayList<Product> HP = new ArrayList<>();
        HP.add(new Product("HP Pavilion", 1199.99, category3, Brand.HP, 4.5));
        HP.add(new Product("HP Victus", 499.99, category3, Brand.HP, 4.3));
        Order order3=new Order();
        order3.setProducts(HP);

        // Create the fourth ArrayList of products
        ArrayList<Product> Microsoft = new ArrayList<>();
        Microsoft.add(new Product("Microsoft Surface Pro 6", 1299.99, category3, Brand.Microsoft, 4.7));
        Microsoft.add(new Product("Microsoft Surface Pro 7", 199.99, category3, Brand.Microsoft, 4.4));
        Order order4 = new Order();
        order4.setProducts(Microsoft);

        // Create the fifth ArrayList of products
        ArrayList<Product> combo = new ArrayList<>();
        combo.add(new Product("Iphone 12", 799.99, category1, Brand.Apple, 4.5));
        combo.add(new Product("Iphone 13", 799.99, category1, Brand.Apple, 4.5));
        combo.add(new Product("Galaxy Tab S9 FE+", 699.99, category2, Brand.Samsung, 4.5));
        combo.add(new Product("Microsoft Surface Pro 7", 199.99, category3, Brand.Microsoft, 4.4));
        Order order5 =new Order();
        order5.setProducts(combo);
        
    }
}
