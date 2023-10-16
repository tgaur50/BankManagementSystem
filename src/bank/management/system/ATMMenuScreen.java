package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class ATMMenuScreen extends JFrame {
    public ATMMenuScreen(int formNum, long cardNum, int pin){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel backgroundImg = new JLabel(ic1);
        backgroundImg.setLayout(null);
        backgroundImg.setBounds(0, 0, 800, 800);
        add(backgroundImg);

        JLabel heading = new JLabel("Please Select Your Transaction");
        heading.setFont(new Font("Arial", Font.BOLD, 14));
        heading.setForeground(Color.white);
        heading.setBounds(200, 270, 300, 30);
        backgroundImg.add(heading);

        JButton deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Arial", Font.PLAIN, 10));
        deposit.setOpaque(true);
        deposit.setFocusPainted(false);
        deposit.setBorderPainted(false);
        deposit.setBounds(150, 370, 115, 25);
        backgroundImg.add(deposit);

        JButton withdraw = new JButton("CASH WITHDRAWL");
        withdraw.setFont(new Font("Arial", Font.PLAIN, 10));
        withdraw.setOpaque(true);
        deposit.setFocusPainted(false);
        withdraw.setBorderPainted(false);
        withdraw.setBounds(290, 370, 160, 25);
        backgroundImg.add(withdraw);

        JButton fastcash = new JButton("FAST CASH");
        fastcash.setFont(new Font("Arial", Font.PLAIN, 10));
        fastcash.setOpaque(true);
        deposit.setFocusPainted(false);
        fastcash.setBorderPainted(false);
        fastcash.setBounds(150, 400, 115, 25);
        backgroundImg.add(fastcash);

        JButton miniStm = new JButton("MINI STATEMENT");
        miniStm.setFont(new Font("Arial", Font.PLAIN, 10));
        miniStm.setOpaque(true);
        deposit.setFocusPainted(false);
        miniStm.setBorderPainted(false);
        miniStm.setBounds(290, 400, 160, 25);
        backgroundImg.add(miniStm);

        JButton pinchnange = new JButton("PIN CHANGE");
        pinchnange.setFont(new Font("Arial", Font.PLAIN, 10));
        pinchnange.setOpaque(true);
        deposit.setFocusPainted(false);
        pinchnange.setBorderPainted(false);
        pinchnange.setBounds(150, 430, 115, 25);
        backgroundImg.add(pinchnange);

        JButton balenquiry = new JButton("BALANCE ENQUIRY");
        balenquiry.setFont(new Font("Arial", Font.PLAIN, 10));
        balenquiry.setOpaque(true);
        deposit.setFocusPainted(false);
        balenquiry.setBorderPainted(false);
        balenquiry.setBounds(290, 430, 160, 25);
        backgroundImg.add(balenquiry);

        JButton exit = new JButton("EXIT");
        exit.setFont(new Font("Arial", Font.PLAIN, 10));
        exit.setOpaque(true);
        deposit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setBounds(290, 460, 160, 25);
        backgroundImg.add(exit);

        deposit.addActionListener(e -> {
            new DepositAmtScreen(formNum, cardNum, pin);
            dispose();
        });

        withdraw.addActionListener(e -> {
            new WithdrawAmtScreen(formNum, cardNum, pin);
            dispose();
        });

        fastcash.addActionListener(e -> {
            new FastCashWithdrawlScreen(formNum, cardNum, pin);
            dispose();
        });

        miniStm.addActionListener(e -> {
            new MiniStatementScreen(formNum, cardNum, pin);
        });

        pinchnange.addActionListener(e -> {
            new PinChangeScreen(formNum, cardNum, pin);
            dispose();
        });

        balenquiry.addActionListener(e -> {
            new BalanceEnquiryScreen(formNum, cardNum, pin);
            dispose();
        });

        exit.addActionListener(e -> {
            dispose();
        });

        setLayout(null);
        setVisible(true);
        setSize(800, 800);
        setLocation(300, 10);
    }
//    public static void main(String[] args){
//        new ATMMenuScreen();
//    }
}
