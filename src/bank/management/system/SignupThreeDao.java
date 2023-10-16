package bank.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupThreeDao {
    public static void insertDetailsToSignupPageThree(int formNum, String acctType, long cardNum, int pin,
                                                      String listOfServices, boolean isAgreed){
        String query = "INSERT INTO SignupThree(formNumber, accountType, cardNumber, PIN, requiredServices, " +
                "isAgreed) VALUES(?,?,?,?,?,?)";
        ConnectionToJdbc con = new ConnectionToJdbc();
        Connection cn = con.getCon();
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            ps.setString(2, acctType);
            ps.setLong(3, cardNum);
            ps.setInt(4, pin);
            ps.setString(5, listOfServices);
            ps.setBoolean(6, isAgreed);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
