package Backend.dao;

import Backend.entity.Category;
import Database.Database;

import java.util.ArrayList;

public class CategoryDAO {
    public void addCategory(int id, String name) {
        Category newCategory = new Category(id, name);
        Database.categories.add(newCategory);
        System.out.println("Category added successfully.");
    }
    public void updateCategory(int id, String newName) {
        for (Category category : Database.categories) {
            if (category != null && category.getId() == id) {
                category.setName(newName);
                System.out.println("Category updated successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }
    public void deleteCategory(int id) {
        for (int i = 0; i < Database.categories.size(); i++) {
            Category category = Database.categories.get(i);
            if (category != null && category.getId() == id) {
                Database.categories.remove(i);
                System.out.println("Category deleted successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    public ArrayList<Category> getAllCategories() {
        return new ArrayList<>(Database.categories);
    }
}
