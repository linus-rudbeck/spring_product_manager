package se.distansakademin.data_access;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    protected Connection conn;
    public Database(){
        try {
            var dbUrl = "jdbc:mysql://localhost/product_manager";
            var dbUsername = "root";
            var dbPassword = "";

            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
