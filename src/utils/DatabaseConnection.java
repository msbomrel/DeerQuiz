package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by msb on 8/25/2016.
 */
public class DatabaseConnection {
    String url = "jdbc:mysql://localhost:3306/java";
    String user = "root";
    String password = "123";

    Connection connection = null;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query) {
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstm;
    }
}
