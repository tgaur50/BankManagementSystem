package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinChangeScreen extends JFrame {
    public PinChangeScreen(int formNum, long cardNum, int pin){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = ic.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel background = new JLabel(ic1);
        background.setLayout(null);
        background.setBounds(0, 0, 800, 800);
        add(background);

        JLabel msg = new JLabel("CHANGE YOUR PIN");
        msg.setForeground(Color.WHITE);
        msg.setFont(new Font("Arial", Font.BOLD, 14));
        msg.setBounds(225, 250, 300, 30);
        background.add(msg);

        JLabel newPin = new JLabel("New Pin:");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("Arial", Font.BOLD, 14));
        newPin.setBounds(145, 280, 150, 30);
        background.add(newPin);

        JPasswordField newPinField = new JPasswordField();
        newPinField.setFont(new Font("Arial", Font.BOLD, 14));
        newPinField.setBounds(290, 280, 170, 30);
        background.add(newPinField);

        JLabel reEnterPin = new JLabel("Re-Enter New Pin:");
        reEnterPin.setForeground(Color.WHITE);
        reEnterPin.setFont(new Font("Arial", Font.BOLD, 14));
        reEnterPin.setBounds(145, 315, 150, 30);
        background.add(reEnterPin);

        JPasswordField rePinField = new JPasswordField();
        rePinField.setFont(new Font("Arial", Font.BOLD, 14));
        rePinField.setBounds(290, 315, 170, 30);
        background.add(rePinField);

        JButton changeBtn = new JButton("CHANGE");
        changeBtn.setOpaque(true);
        changeBtn.setFocusPainted(false);
        changeBtn.setBorderPainted(false);
        changeBtn.setFont(new Font("Arial", Font.PLAIN, 10));
        changeBtn.setBounds(310, 430, 140, 25);
        background.add(changeBtn);

        JButton back = new JButton("BACK");
        back.setOpaque(true);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setFont(new Font("Arial", Font.PLAIN, 10));
        back.setBounds(310, 460, 140, 25);
        background.add(back);

        changeBtn.addActionListener(e -> {
            String newPinVal = newPinField.getText();
            String reEnterPinVal = rePinField.getText();
            if (checkPin(newPinVal) && checkPin(reEnterPinVal))
            {
                if (newPinVal.equals(reEnterPinVal)){
                    int finalPinVal = Integer.parseInt(newPinVal);
                    CustomerTransactionsDao ctd = new CustomerTransactionsDao();
                    if (ctd.changePin(formNum, finalPinVal) > 0){
                        JOptionPane.showMessageDialog(null, "Pin is changed successfully");
                        new ATMMenuScreen(formNum, cardNum, finalPinVal);
                        dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Re-enter the correct pin value");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter valid value");
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
    }

    public boolean checkPin(String pin){
        String regex = "[0-9]{4}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pin);
        return m.matches();
    }
}
