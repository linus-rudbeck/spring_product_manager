package se.distansakademin.business_logic;

import se.distansakademin.data_access.CategoriesDatabase;
import se.distansakademin.models.Category;

import java.util.List;

public class CategoriesService {

    public static List<Category> GetAll(){
        var db = new CategoriesDatabase();

        return db.getAll();
    }

    public static Category GetOneById(int categoryId){
        var db = new CategoriesDatabase();

        return db.getOneById(categoryId);
    }

    public static boolean EditCategory(int categoryId, Category category) {
        var db = new CategoriesDatabase();

        return db.updateCategory(categoryId, category);
    }
}
