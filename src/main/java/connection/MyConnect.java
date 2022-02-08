package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
    private final String url = "jdbc:mysql://localhost:3306/jdbc_dao?useSSL=false";
    private final String userName = "root";
    private final String passWord = "123456";

    public Connection getConnection() {
        Connection connection = null;
        try {
            // đổi class hiện tại về quản lý như 1 drive
            Class.forName("com.mysql.jdbc.Driver");

            //quản lý connection vs driver manager
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
