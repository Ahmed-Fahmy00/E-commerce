package Backend.dao;

import Backend.entity.Category;
import Database.Database;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DAO_interface<Category>{

    @Override
    public void add(Category category) {
        Database.categories.add(category);
    }

    @Override
    public void delete(Category category) {
        for (Category category1 : Database.categories) {
            if (category1.getId() == category.getId()) {
                Database.categories.remove(category1);
            }
        }
    }

    @Override
    public void update(Category oldCategory, Category updatedCategory) {
        for (int i = 0; i < Database.categories.size(); i++) {
            Category existingCategory = Database.categories.get(i);
            if (existingCategory.getId() == oldCategory.getId()) {
                Database.categories.set(i, updatedCategory);
            }
        }
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(Database.categories);
    }

}
