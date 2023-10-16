package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends JFrame {
    Container c;
    public Login(){
        c = getContentPane();
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img = ic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic1);
        imgLabel.setBounds(100, 50, 100, 100);
        add(imgLabel);

        JLabel titleLable = new JLabel("Welcome to ATM");
        titleLable.setFont(new Font("Arial", Font.BOLD, 38));
        titleLable.setBounds(250, 80, 400, 40);
        add(titleLable);

        JLabel card = new JLabel("Card No:");
        card.setBounds(150, 180, 150, 40);
        card.setFont(new Font("Arial", Font.BOLD, 30));
        add(card);
        JTextField cardField = new JTextField();
        cardField.setBounds(350, 180, 250, 40);
        add(cardField);
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(150, 230, 150, 40);
        pin.setFont(new Font("Arial", Font.BOLD, 30));
        add(pin);
        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(350, 230, 250, 40);
        add(pinField);

        JButton signInBtn = new JButton("SIGN IN");
        signInBtn.setBounds(350, 300, 100, 30);
        signInBtn.setOpaque(true);
        signInBtn.setBorderPainted(false);
        signInBtn.setBackground(Color.BLACK);
        signInBtn.setForeground(Color.WHITE);
        add(signInBtn);
        JButton clear = new JButton("CLEAR");
        clear.setBounds(500, 300, 100, 30);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        JButton signup = new JButton("SIGN UP");
        signup.setBounds(350, 350, 250, 30);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);

        signInBtn.addActionListener(e -> {
            String cardNum = cardField.getText();
            @SuppressWarnings("deprecation") String pinVal = pinField.getText();
            int formNum;
            if (checkCardNum(cardNum) && checkPin(pinVal)){
                LoginDao lgn = new LoginDao();
                formNum = lgn.authenticateLogin(Long.parseLong(cardNum), Integer.parseInt(pinVal));
                if (formNum != 0){
                    JOptionPane.showMessageDialog(null, "Successfully " +
                            "logged in!");
                    new ATMMenuScreen(formNum, Long.parseLong(cardNum), Integer.parseInt(pinVal));
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect login details!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials! " +
                        "Either " + "card number or pin is invalid!");
            }
        });

        clear.addActionListener(e -> {
            cardField.setText("");
            pinField.setText("");
        });

        signup.addActionListener(e -> {
            new SignupPageOne();
            dispose();
        });

        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 460);
        setLocation(300, 200);
        setLayout(null);
        c.setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Setting background image failed try
//        setSize(400, 400);
//        setVisible(true);
//        setLayout(new BorderLayout());
//        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")));
//        c.add(background);
//        background.setLayout(new FlowLayout());
    }

    public boolean checkCardNum(String cardNum){
        String regex = "[0-9]{16}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cardNum);
        return m.matches();
    }

    public boolean checkPin(String pin){
        String regex = "[0-9]{4}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pin);
        return m.matches();
    }

    public static void main(String[] args){
        new Login();
    }
}
