package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class BalanceEnquiryScreen extends JFrame {
    public BalanceEnquiryScreen(int formNum, long cardNum, int pin){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel backgroundImg = new JLabel(ic1);
        backgroundImg.setLayout(null);
        backgroundImg.setBounds(0, 0, 800, 800);
        add(backgroundImg);

        CustomerTransactionsDao ctd = new CustomerTransactionsDao();
        int amount = ctd.checkAccountBalance(formNum);

        JLabel msg = new JLabel("Your Current Account Balance is Rs " + amount);
        msg.setForeground(Color.WHITE);
        msg.setFont(new Font("Arial", Font.BOLD, 14));
        msg.setBounds(150, 265, 300, 30);
        backgroundImg.add(msg);

        JButton back = new JButton("BACK");
        back.setOpaque(true);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Arial", Font.PLAIN, 10));
        back.setBounds(310, 460, 140, 30);
        backgroundImg.add(back);

        back.addActionListener(e -> {
            new ATMMenuScreen(formNum, cardNum, pin);
            dispose();
        });


        setSize(800, 800);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }
}
