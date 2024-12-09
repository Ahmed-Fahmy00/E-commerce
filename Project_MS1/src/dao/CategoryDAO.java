package dao;

import entity.Category;
import static database.Database.categories;

public class CategoryDAO {

    public void addCategory(int id, String name) {
        boolean added = database.Database.add(categories, new Category(id, name));
        if (added) {
            System.out.println("Category added successfully.");
        } else {
            System.out.println("Failed to add category: Array is full.");
        }
    }

    public void updateCategory(int id, String newName) {
        for (int i = 0; i < categories.length; i++) {
            Category category = categories[i];
            if (category != null && category.getId() == id) {
                category.setName(newName);
                System.out.println("Category updated successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }

    public void deleteCategory(int id) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i] != null && categories[i].getId() == id) {
                categories[i] = null; // Set the array element to null
                System.out.println("Category deleted successfully.");
                return;
            }
        }
        System.out.println("Category not found.");
    }
}
