package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // Single instance of Connection
    private static Database instance;
    private Connection connection;

    // Database config — you can change these for any project
    private static final String URL = "jdbc:mysql://localhost:3306/credit_scoring";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Private constructor to prevent instantiation
    private Database() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✅ Database connected successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database:");
            e.printStackTrace();
        }
    }

    // Public method to get the single instance
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) { // thread-safe
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    // Getter for the connection
    public Connection getConnection() {
        return connection;
    }
}
