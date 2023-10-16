package bank.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    ConnectionToJdbc con;
    private Connection cn;
    PreparedStatement ps;
    public LoginDao(){
        con = new ConnectionToJdbc();
        cn = con.getCon();
    }
    public void insertDetailsToLogin(int formNum, long cardNum, int pin){
        String query = "insert into Login(formNumber, cardNumber, PIN) VALUES(?, ?, ?)";
        try {
            ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            ps.setLong(2, cardNum);
            ps.setInt(3, pin);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int authenticateLogin(long cardNum, int pin){
        int formNum = 0;
        ResultSet rs;
        String query = "select * from Login where cardNumber = ? and PIN = ?";
        try {
            ps = cn.prepareStatement(query);
            ps.setLong(1, cardNum);
            ps.setInt(2, pin);
            rs = ps.executeQuery();
            if (rs.next()){
                formNum = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return formNum;
    }
}
