package bank.management.system;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MiniStatementScreen extends JFrame {
    private ResultSet rs;
    public MiniStatementScreen(int formNum, long cardNum, int pin){
        CustomerTransactionsDao ctd = new CustomerTransactionsDao();

        JLabel heading = new JLabel("Indian Bank");
        heading.setBounds(150, 20, 100, 30);
        add(heading);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setBounds(30, 80, 100, 30);
        add(cardNumber);

        String cardNumberVal = ctd.getCardNumber(formNum);
        if (!cardNumberVal.equals("")){
            String maskedVal = "********";
            cardNumberVal = cardNumberVal.substring(0, 4) + maskedVal
                    + cardNumberVal.substring(12);
        }

        JLabel cardNumVal = new JLabel(cardNumberVal);
        cardNumVal.setBounds(150, 80, 150, 30);
        add(cardNumVal);

        rs = ctd.getMiniStatement(formNum);
//        JScrollPane sp = new JScrollPane();
//        int x = 30, y = 180, width = 200, height = 30;
        ArrayList<String> statementList = new ArrayList<>();
        while (true){
            try {
                if (rs.next()){
                    String dateTime = rs.getString(1);
                    String tranType = rs.getString(2);
                    int amt = rs.getInt(3);
                    String statementVal = dateTime + "\t" + "\t" + tranType + "\t" + "\t" + "\t" + amt;
                    statementList.add(statementVal);

//                    JLabel dateTimeField = new JLabel(dateTime);
//                    dateTimeField.setBounds(x, y, width, height);
//                    sp.add(dateTimeField);
//                    JLabel tranTypeField = new JLabel(tranType);
//                    x = x + width + 10;
//                    width = 100;
//                    tranTypeField.setBounds(x, y, width, height);
//                    sp.add(tranTypeField);
//                    JLabel amtField = new JLabel(String.valueOf(amt));
//                    x = x + width + 10;
//                    amtField.setBounds(x, y, width, height);
//                    sp.add(amtField);
                }
                else {
                    break;
                }
//                x = 30;
//                y = y + height + 10;
//                width = 200;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        JList<String> list = new JList<>(statementList.toArray(new String[statementList.size()]));
        list.setVisibleRowCount(5);
        JPanel panel = new JPanel();
//        panel.setLayout(null);
        panel.setBounds(-10, 180, 400, 100);
        panel.add(new JScrollPane(list));
        add(panel);

        int totalBal = ctd.checkAccountBalance(formNum);
        JLabel totalBalance = new JLabel("Your total Balance is Rs " + totalBal);
        totalBalance.setBounds(30, 380, 300, 30);
        add(totalBalance);

        JButton exit = new JButton("Exit");
        exit.setBounds(30, 460, 100, 30);
        add(exit);

        exit.addActionListener(e -> {
            dispose();
        });

        setTitle("Mini Statement");
        setSize(400, 550);
        setLocation(50, 50);
        setLayout(null);
        setVisible(true);
    }
//    public static void main(String[] args){
//        new MiniStatementScreen();
//    }
}
