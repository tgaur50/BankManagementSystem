package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToJdbc {
    Connection con;
    public ConnectionToJdbc(){
        String url = "jdbc:mysql:///BankManagementSystem";
        String userName = "root";
        String password = "ThisisMySql11*";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCon() {
        return con;
    }
}
