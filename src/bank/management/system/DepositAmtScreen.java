package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepositAmtScreen extends JFrame {
    public DepositAmtScreen(int formNum, long cardNum, int pin){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel background = new JLabel(ic1);
        background.setLayout(null);
        background.setBounds(0, 0, 800, 800);
        add(background);

        JLabel msg = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
//        msg.setOpaque(true);
        msg.setForeground(Color.white);
        msg.setFont(new Font("Arial", Font.BOLD, 14));
        msg.setBounds(150, 270, 300, 30);
        background.add(msg);
        JTextField msgVal = new JTextField();
        msgVal.setFont(new Font("Arial", Font.BOLD, 14));
        msgVal.setBounds(150, 310, 290, 30);
        background.add(msgVal);

        JButton deposit = new JButton("DEPOSIT");
        deposit.setOpaque(true);
        deposit.setBorderPainted(false);
        deposit.setBounds(300, 420, 150, 30);
        background.add(deposit);

        JButton back = new JButton("BACK");
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setBounds(300, 455, 150, 30);
        background.add(back);

        deposit.addActionListener(e -> {
            String bal = msgVal.getText();
            String regex = "[0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bal);
            if (m.matches()){
                JOptionPane.showMessageDialog(null, "Rs. " + bal + " Deposited Successfully");
                CustomerTransactionsDao ctd = new CustomerTransactionsDao();
                ctd.deposit(formNum, cardNum, pin, Integer.parseInt(bal));
                ctd.insertIntoAccountStatement(formNum, String.valueOf(new Date()), "Deposit",
                        Integer.parseInt(bal));
                new ATMMenuScreen(formNum, cardNum, pin);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter valid value!");
            }
        });

        back.addActionListener(e -> {
            new ATMMenuScreen(formNum, cardNum, pin);
            dispose();
        });

        setSize(800, 800);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);

//        setLayout(new BorderLayout());
//        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")));
//        add(background);
//        background.setLayout(null);
    }
//    public static void main(String[] args){
//        new DepositAmtScreen();
//    }
}
