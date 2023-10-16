package bank.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpOneDao {
    public static void insertDetailsToSignupOne(int formNo, String name, String fName,
                                                String dob, String gender, String email,
                                                String maritalStatus, String addr, String city,
                                                String pincode, String state){
        String query = "insert into SignupOne(formNumber, name, fatherName, dateOfBirth, " +
                "gender, email, maritalStatus, address, city, pincode, state) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        ConnectionToJdbc cn = new ConnectionToJdbc();
        Connection con = cn.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, formNo);
            ps.setString(2, name);
            ps.setString(3, fName);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, maritalStatus);
            ps.setString(8, addr);
            ps.setString(9, city);
            ps.setString(10, pincode);
            ps.setString(11, state);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
