package bank.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupTwoDao {
    public static void insertDetailsToSignupPageTwo(int formNum, String religion, String category, String income,
                                                    String qualification, String occupation, String panNum,
                                                    String aadhaarNum, boolean isSenior, boolean hasExistingAcct){
        String query = "INSERT INTO SignupTwo(formNumber, religion, category, income, qualification, occupation, " +
                "pannumber, aadhaarnumber, seniorcitizen, existingaccount) VALUES(?,?,?,?,?,?,?,?,?,?)";
        ConnectionToJdbc con = new ConnectionToJdbc();
        Connection cn = con.getCon();
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            ps.setString(2, religion);
            ps.setString(3, category);
            ps.setString(4, income);
            ps.setString(5, qualification);
            ps.setString(6, occupation);
            ps.setString(7, panNum);
            ps.setString(8, aadhaarNum);
            ps.setBoolean(9, isSenior);
            ps.setBoolean(10, hasExistingAcct);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
