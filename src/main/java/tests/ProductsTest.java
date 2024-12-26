package tests;

import Backend.entity.Enum.Brand;
import Backend.service.CategoryService;
import Backend.service.ProductService;
import Backend.entity.Category;
import Backend.entity.Product;


public class ProductsTest {
    static ProductService productService = new ProductService();

    public static void makeproducts() {

        Category category1 = new Category("Phones");
        Category category2 = new Category("Tablets");
        Category category3 = new Category("Laptops");
        Category category4 = new Category("PC");
        Category category5 = new Category("Accessories");

        CategoryService categoryService = new CategoryService();
        categoryService.createCategory(category1);
        categoryService.createCategory(category2);
        categoryService.createCategory(category3);
        categoryService.createCategory(category4);
        categoryService.createCategory(category5);

        Product product1 = new Product("IPhone 12", 799.99, category1, Brand.Apple, 4.5);
        Product product2 = new Product("IPhone 13", 799.99, category1, Brand.Apple, 4.5);
        Product product3 = new Product("IPhone 14", 799.99, category1, Brand.Apple, 4.5);
        Product product4 = new Product("IPhone 16", 999.99, category1, Brand.Apple, 4.5);
        Product product5 = new Product("IPhone 16 Pro Max", 899.99, category1, Brand.Apple, 4.4);
        Product product6 = new Product("Apple Watch", 399.99, category5, Brand.Apple, 4.7);
        Product product7 = new Product("Airpods Pro", 299.99, category5, Brand.Apple, 4.8);
        Product product8 = new Product("Macbook Pro", 1299.99, category3, Brand.Apple, 4.9);
        Product product9 = new Product("IPad Pro", 899.99, category2, Brand.Apple, 4.4);

        Product product10 = new Product("Galaxy S24 Ultra", 1999.99, category1, Brand.Samsung, 4.4);
        Product product11 = new Product("Galaxy Fold 6", 699.99, category2, Brand.Samsung, 4.4);
        Product product12 = new Product("Galaxy Z Flip 6", 699.99, category2, Brand.Samsung, 4.4);
        Product product13 = new Product("Galaxy Tab S9 FE+", 699.99, category2, Brand.Samsung, 4.5);
        Product product14 = new Product("Samsung Buds 2", 99.99, category5, Brand.Samsung, 4.5);
        Product product15 = new Product("Galaxy Watch", 399.99, category5, Brand.Samsung, 4.6);
        Product product16 = new Product("Odyssey G5 Samsung Monitor", 699.99, category4, Brand.Samsung, 4.4);

        Product product17 = new Product("HP Pavilion", 1199.99, category3, Brand.HP, 4.5);
        Product product18 = new Product("HP Victus", 499.99, category3, Brand.HP, 4.3);

        Product product19 = new Product("Microsoft Surface Pro 6", 1299.99, category3, Brand.Microsoft, 4.7);
        Product product20 = new Product("Microsoft Surface Pro 7", 199.99, category3, Brand.Microsoft, 4.4);

        productService.createProduct(product1);
        productService.createProduct(product2);
        productService.createProduct(product3);
        productService.createProduct(product4);
        productService.createProduct(product5);
        productService.createProduct(product6);
        productService.createProduct(product7);
        productService.createProduct(product8);
        productService.createProduct(product9);
        productService.createProduct(product10);
        productService.createProduct(product11);
        productService.createProduct(product12);
        productService.createProduct(product13);
        productService.createProduct(product14);
        productService.createProduct(product15);
        productService.createProduct(product16);
        productService.createProduct(product17);
        productService.createProduct(product18);
        productService.createProduct(product19);
        productService.createProduct(product20);

    }

}