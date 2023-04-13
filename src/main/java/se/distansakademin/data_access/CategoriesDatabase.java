package se.distansakademin.data_access;

import se.distansakademin.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDatabase extends Database{

    public List<Category> getAll(){
        List<Category> categories = new ArrayList<>();

        try{
            String query = "SELECT * FROM categories;";

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int categoryId = result.getInt("category_id");
                String categoryName = result.getString("category_name");
                String description = result.getString("description");

                Category category = new Category(categoryId, categoryName, description);

                categories.add(category);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return categories;
    }

    public Category getOneById(int categoryId){
        Category category = null;

        try{
            String query = "SELECT * FROM categories WHERE category_id = ?;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, categoryId);

            stmt.execute();

            ResultSet result = stmt.getResultSet();

            if (result.next()){
                String categoryName = result.getString("category_name");
                String description = result.getString("description");

                category = new Category(categoryId, categoryName, description);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return category;
    }

    public boolean edit(int categoryId, Category category) {
        String query = "UPDATE categories SET category_name = ?, description = ? WHERE category_id = ?;";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, categoryId);

            success = stmt.execute();

            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public boolean create(Category category) {
        String query = "INSERT INTO categories (category_name, description) VALUES (?, ?);";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getDescription());

            success = stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public boolean delete(int categoryId) {
        String query = "DELETE FROM categories WHERE category_id = ?;";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, categoryId);

            success = stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }


}
