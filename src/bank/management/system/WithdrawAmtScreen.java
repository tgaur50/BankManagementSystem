package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithdrawAmtScreen extends JFrame{
    public WithdrawAmtScreen(){}
    public WithdrawAmtScreen(int formNum, long cardNum, int pin){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel background = new JLabel(ic1);
        background.setLayout(null);
        background.setBounds(0, 0, 800, 800);
        add(background);

        JLabel warning = new JLabel("MAXIMUM WITHDRAWAL IS RS. 10,000");
        warning.setForeground(Color.WHITE);
        warning.setFont(new Font("Arial", Font.BOLD, 14));
        warning.setBounds(170, 250, 300, 30);
        background.add(warning);

        JLabel msg = new JLabel("PLEASE ENTER YOUR AMOUNT");
//        msg.setOpaque(true);
        msg.setForeground(Color.white);
        msg.setFont(new Font("Arial", Font.BOLD, 14));
        msg.setBounds(150, 290, 300, 30);
        background.add(msg);
        JTextField msgVal = new JTextField();
        msgVal.setFont(new Font("Arial", Font.BOLD, 14));
        msgVal.setBounds(150, 325, 290, 30);
        background.add(msgVal);

        JButton withdraw = new JButton("WITHDRAW");
        withdraw.setOpaque(true);
        withdraw.setBorderPainted(false);
        withdraw.setBounds(300, 420, 150, 30);
        background.add(withdraw);

        JButton back = new JButton("BACK");
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setBounds(300, 455, 150, 30);
        background.add(back);

        withdraw.addActionListener(e -> {
            String bal = msgVal.getText();
            String regex = "[0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bal);
            if (m.matches()){
                CustomerTransactionsDao ctd = new CustomerTransactionsDao();
                if (ctd.withdraw(formNum, Integer.parseInt(bal)) > 0){
                    ctd.insertIntoAccountStatement(formNum, String.valueOf(new Date()), "Withdrawal",
                            Integer.parseInt(bal));
                    JOptionPane.showMessageDialog(null, "Rs. " + bal + " Withdrawn Successfully");
                    new ATMMenuScreen(formNum, cardNum, pin);
                    dispose();
                }
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
//        setLocationRelativeTo(null);
        setVisible(true);

//        setLayout(new BorderLayout());
//        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")));
//        add(background);
//        background.setLayout(null);
    }
    public static void main(String[] args){
        new WithdrawAmtScreen();
    }
}
