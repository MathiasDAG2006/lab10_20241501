package Daos;

import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {

    String URL = "jdbc:mysql://localhost:3306/lab10_telecom";
    String USER = "root";
    String PASSWORD = "12345678";

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
