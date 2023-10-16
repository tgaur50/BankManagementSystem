package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FastCashWithdrawlScreen extends JFrame implements ActionListener {
    private final int formNum;
    private final long cardNum;
    private final int pin;
    public FastCashWithdrawlScreen(int formNum, long cardNum, int pin){
        this.formNum = formNum;
        this.cardNum = cardNum;
        this.pin = pin;
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel background = new JLabel(ic1);
        background.setLayout(null);
        background.setBounds(0, 0, 800, 800);
        add(background);

        JLabel msg = new JLabel("SELECT WITHDRAWAL AMOUNT");
        msg.setForeground(Color.white);
        msg.setFont(new Font("Arial", Font.BOLD, 14));
        msg.setBounds(200, 265, 300, 30);
        background.add(msg);

        JButton btn100 = new JButton("Rs. 100");
        btn100.setOpaque(true);
        btn100.setFocusPainted(false);
        btn100.setBorderPainted(false);
        btn100.setFont(new Font("Arial", Font.PLAIN, 10));
        btn100.setBounds(145, 360, 140, 30);
        background.add(btn100);

        JButton btn500 = new JButton("Rs. 500");
        btn500.setOpaque(true);
        btn500.setBorderPainted(false);
        btn500.setFont(new Font("Arial", Font.PLAIN, 10));
        btn500.setBounds(310, 360, 140, 30);
        background.add(btn500);

        JButton btn1000 = new JButton("Rs. 1000");
        btn1000.setOpaque(true);
        btn1000.setFocusPainted(false);
        btn1000.setBorderPainted(false);
        btn1000.setFont(new Font("Arial", Font.PLAIN, 10));
        btn1000.setBounds(145, 395, 140, 30);
        background.add(btn1000);

        JButton btn2000 = new JButton("Rs. 2000");
        btn2000.setOpaque(true);
        btn2000.setBorderPainted(false);
        btn2000.setFont(new Font("Arial", Font.PLAIN, 10));
        btn2000.setBounds(310, 395, 140, 30);
        background.add(btn2000);

        JButton btn5000 = new JButton("Rs. 5000");
        btn5000.setOpaque(true);
        btn5000.setFocusPainted(false);
        btn5000.setBorderPainted(false);
        btn5000.setFont(new Font("Arial", Font.PLAIN, 10));
        btn5000.setBounds(145, 430, 140, 30);
        background.add(btn5000);

        JButton btn10000 = new JButton("Rs. 10000");
        btn10000.setOpaque(true);
        btn10000.setBorderPainted(false);
        btn10000.setFont(new Font("Arial", Font.PLAIN, 10));
        btn10000.setBounds(310, 430, 140, 30);
        background.add(btn10000);

        JButton back = new JButton("BACK");
        back.setOpaque(true);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Arial", Font.PLAIN, 10));
        back.setBounds(310, 465, 140, 25);
        background.add(back);

        btn100.addActionListener(this);
        btn500.addActionListener(this);
        btn1000.addActionListener(this);
        btn2000.addActionListener(this);
        btn5000.addActionListener(this);
        btn10000.addActionListener(this);

        back.addActionListener(e -> {
            new ATMMenuScreen(formNum, cardNum, pin);
            dispose();
        });

        setSize(800, 800);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String amt = b.getText();
        int amount = Integer.parseInt(amt.substring(4));
        CustomerTransactionsDao ctd = new CustomerTransactionsDao();
        if (ctd.withdraw(formNum, amount) > 0){
            ctd.insertIntoAccountStatement(formNum, String.valueOf(new Date()), "Withdrawal", amount);
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
            new ATMMenuScreen(formNum, cardNum, pin);
            dispose();
        }
    }
}
