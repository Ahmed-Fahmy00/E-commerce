package Backend.service;

import Backend.dao.CategoryDAO;
import Backend.entity.Category;

public class CategoryService {

    CategoryDAO categoryDAO = new CategoryDAO();

    public boolean createCategory(Category category) {
        if (category == null || category.getName() == null) {
            System.out.println("Error: Category or name cannot be null.");
            return false;
        }
        if (categoryDAO.getAll().contains(category)) {
            System.out.println("Category already exists.");
            return false;
        }
        categoryDAO.add(category);
        System.out.println("Category added successfully with ID: " + category.getId());
        return true;
    }

}
