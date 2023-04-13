package se.distansakademin.data_access;

import se.distansakademin.models.Category;
import se.distansakademin.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDatabase  extends Database{
    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();

        try{
            String query = "SELECT * FROM products;";

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int productId = result.getInt("product_id");
                int categoryId = result.getInt("category_id");
                String productName = result.getString("product_name");
                int price = result.getInt("price");

                Product product = new Product(productId, categoryId, productName, price);

                products.add(product);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return products;
    }

    public boolean create(Product product) {
        String query = "INSERT INTO products (category_id, product_name, price) VALUES (?, ?, ?);";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, product.getCategoryId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getPrice());

            success = stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public Product getOneById(int productId) {
        Product product = null;

        try{
            String query = "SELECT * FROM products WHERE product_id = ?;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, productId);

            stmt.execute();

            ResultSet result = stmt.getResultSet();

            if (result.next()){
                int categoryId = result.getInt("category_id");
                String categoryName = result.getString("product_name");
                int price = result.getInt("price");

                product = new Product(productId, categoryId, categoryName, price);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return product;
    }

    public boolean edit(int id, Product product) {
        String query = "UPDATE products SET category_id = ?, product_name = ?, price = ? WHERE product_id = ?;";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, product.getCategoryId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getPrice());
            stmt.setInt(4, id);

            success = stmt.execute();

            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public boolean delete(int productId) {
        String query = "DELETE FROM products WHERE product_id = ?;";

        boolean success = false;

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, productId);

            success = stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }
}
