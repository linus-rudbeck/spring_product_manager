package se.distansakademin.business_logic;

import se.distansakademin.data_access.ProductsDatabase;
import se.distansakademin.models.Product;

import java.util.List;

public class ProductsService {
    public static List<Product> GetAll(){
        var db = new ProductsDatabase();

        return db.getAll();
    }
}
