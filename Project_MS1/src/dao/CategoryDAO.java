package dao;

import entity.Category;
import java.util.ArrayList;
import static database.Database.categories;

public class CategoryDAO {

    public void addCategory(int id, String name) {
        Category newCategory = new Category(id, name);
        categories.add(newCategory); // ArrayList automatically resizes
        System.out.println("Category added successfully.");
    }

    public void updateCategory(int id, String newName) {
        for (Category category : categories) {
            if (category != null && category.getId() == id) {
                category.setName(newName);
                System.out.println("Category updated successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    public void deleteCategory(int id) {
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (category != null && category.getId() == id) {
                categories.remove(i); // Remove the category from the list
                System.out.println("Category deleted successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    public ArrayList<Category> getAllCategories() {
        return new ArrayList<>(categories); // Return a copy of the list
    }
}
