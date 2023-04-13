package se.distansakademin.data_access;

import se.distansakademin.models.Product;

import java.sql.ResultSet;
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
}
