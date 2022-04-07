package by.teachmeskills.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static String dbUrl = "jdbc:mysql://localhost:3306/PRODUCT_DB";
    private static String dbUsername = "root";
    private static String dbPassword = "Igor123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
