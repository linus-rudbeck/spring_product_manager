package se.distansakademin.business_logic;

import se.distansakademin.data_access.ProductsDatabase;
import se.distansakademin.models.Product;

import java.util.List;

public class ProductsService {
    public static List<Product> GetAll(){
        var db = new ProductsDatabase();

        return db.getAll();
    }

    public static void Create(Product product) {
        var db = new ProductsDatabase();

        db.create(product);
    }

    public static Product GetOneById(int productId) {
        var db = new ProductsDatabase();

        return db.getOneById(productId);
    }

    public static void Edit(int id, Product product) {
        var db = new ProductsDatabase();

        db.edit(id, product);
    }

    public static void Delete(int productId) {
        var db = new ProductsDatabase();

        db.delete(productId);
    }
}
