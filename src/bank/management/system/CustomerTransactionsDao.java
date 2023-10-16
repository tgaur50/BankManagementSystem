package bank.management.system;

import javax.swing.*;
import java.sql.*;

public class CustomerTransactionsDao {
    private final Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    public CustomerTransactionsDao(){
        ConnectionToJdbc con = new ConnectionToJdbc();
        cn = con.getCon();
    }

    public void insertCustomerDetails(int formNum, long cardNum, int pin){
        String query = "insert into customer(formNumber, cardNumber, pin, amount) VALUES(?,?,?,?)";
        try {
            ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            ps.setLong(2, cardNum);
            ps.setInt(3, pin);
            ps.setInt(4, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deposit(int formNum, int amt){
        String query1 = "select * from customer where formNumber = ?";
        try {
            ps = cn.prepareStatement(query1);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
            if (rs.next()){
                int currentAmount = rs.getInt(4);
                String query2 = "update customer set amount = ? where formNumber = ?";
                ps = cn.prepareStatement(query2);
                ps.setInt(1, (currentAmount + amt));
                ps.setInt(2, formNum);
                ps.executeUpdate();
            }
            else {
                JOptionPane.showMessageDialog(null, "Customer does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int withdraw(int formNum, int amt){
        int numRowsEffected = 0;
        String query1 = "select * from customer where formNumber = ?";
        try {
            ps = cn.prepareStatement(query1);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
            if (rs.next()){
                int currentAmount = rs.getInt(4);
                if (amt > 10000){
                    JOptionPane.showMessageDialog(null, "You cannot withdraw more than Rs. 10,000");
                }
                else if (currentAmount < amt) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                }
                else {
                    String query2 = "update customer set amount = ? where formNumber = ?";
                    ps = cn.prepareStatement(query2);
                    ps.setInt(1, (currentAmount - amt));
                    ps.setInt(2, formNum);
                    numRowsEffected = ps.executeUpdate();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Customer does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRowsEffected;
    }

    public int checkAccountBalance(int formNum){
        int amount = 0;
        String query = "select * from customer where formNumber = ?";
        try {
            ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
            if (rs.next()){
                amount = rs.getInt(4);
            }
            else {
                JOptionPane.showMessageDialog(null, "Customer does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    public int changePin(int formNum, int newPin){
        int numRows = 0;
        String query1 = "select * from customer where formNumber = ?";
        try {
            ps = cn.prepareStatement(query1);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
            if (rs.next()){
                String query2 = "update Login l inner join SignupThree st on l.formNumber = st.formNumber " +
                        "inner join customer c on l.formNumber = c.formNumber set l.pin = ?, st.pin = ?, " +
                        "c.pin = ? where l.formNumber = ?";
                ps = cn.prepareStatement(query2);
                ps.setInt(1, newPin);
                ps.setInt(2, newPin);
                ps.setInt(3, newPin);
                ps.setInt(4, formNum);
                numRows = ps.executeUpdate();
            }
            else {
                JOptionPane.showMessageDialog(null, "Customer does not exist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numRows;
    }

    public void insertIntoAccountStatement(int formNum, String dateTime, String tranType, int amt){
        String query1 = "insert into transactions(formNumber, dateTime, transactionType, amount) " +
                "VALUES (?,?,?,?)";
        try {
            ps = cn.prepareStatement(query1);
            ps.setInt(1, formNum);
            ps.setString(2, dateTime);
            ps.setString(3, tranType);
            ps.setInt(4, amt);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getMiniStatement(int formNum){
        String query = "select dateTime, transactionType, amount from transactions where formNumber = ?";
        try {
            ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public String getCardNumber(int formNum){
        String cardNum = "";
        String query = "select cardNumber from customer where formNumber = ?";
        try {
            ps = cn.prepareStatement(query);
            ps.setInt(1, formNum);
            rs = ps.executeQuery();
            if (rs.next()){
                cardNum = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardNum;
    }
}
