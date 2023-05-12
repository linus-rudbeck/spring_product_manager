package se.distansakademin.data_access;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    protected Connection conn;
    public Database(){

        Dotenv dotenv = Dotenv.configure().load();

        try {
            var dbUrl = dotenv.get("DB_URL");
            var dbUsername = dotenv.get("DB_USER");
            var dbPassword = dotenv.get("DB_PASSWORD");

            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
