package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class SignupPageThree extends JFrame implements ItemListener {
    ArrayList<String> listOfServices = new ArrayList<>();
    public SignupPageThree(long num){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img = ic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic1);
        imgLabel.setBounds(150, 10, 100, 100);
        add(imgLabel);

        JLabel label1 = new JLabel("Page 3: Account Details");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setBounds(300, 40, 250, 30);
        add(label1);

        JLabel label2 = new JLabel("Form No: " + num);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        label2.setBounds(680, 10, 100, 30);
        add(label2);

        JLabel acctType = new JLabel("Account Type:");
        acctType.setFont(new Font("Arial", Font.BOLD, 16));
        acctType.setBounds(110, 140, 150, 30);
        add(acctType);

        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton savingAcct = new JRadioButton("Saving Account");
        savingAcct.setFont(new Font("Arial", Font.BOLD, 14));
        savingAcct.setBounds(100, 180, 150, 30);
        JRadioButton fixedDepAcct = new JRadioButton("Fixed Deposit Account");
        fixedDepAcct.setFont(new Font("Arial", Font.BOLD, 14));
        fixedDepAcct.setBounds(350, 180, 200, 30);
        JRadioButton currentAcct = new JRadioButton("Current Account");
        currentAcct.setFont(new Font("Arial", Font.BOLD, 14));
        currentAcct.setBounds(100, 220, 150, 30);
        JRadioButton recurringDepAcct = new JRadioButton("Recurring Deposit Account");
        recurringDepAcct.setFont(new Font("Arial", Font.BOLD, 14));
        recurringDepAcct.setBounds(350, 220, 250, 30);

        bg1.add(savingAcct);
        bg1.add(fixedDepAcct);
        bg1.add(currentAcct);
        bg1.add(recurringDepAcct);

        add(savingAcct);
        add(fixedDepAcct);
        add(currentAcct);
        add(recurringDepAcct);

        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Arial", Font.BOLD, 16));
        cardNo.setBounds(110, 300, 150, 30);
        add(cardNo);

        JLabel cardNumDesc = new JLabel("(Your 16-digit Card number)");
        cardNumDesc.setBounds(110, 320, 300, 30);
        add(cardNumDesc);

        JLabel cardVal = new JLabel("XXXX-XXXX-XXXX-4184");
        cardVal.setFont(new Font("Arial", Font.BOLD, 16));
        cardVal.setBounds(350, 300, 300, 30);
        add(cardVal);

        JLabel cardValDesc = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        cardValDesc.setBounds(350, 320, 500, 30);
        add(cardValDesc);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Arial", Font.BOLD, 16));
        pin.setBounds(110, 370, 100, 30);
        add(pin);

        JLabel pinDesc = new JLabel("(4-digit password)");
        pinDesc.setBounds(110, 390, 200, 30);
        add(pinDesc);

        JLabel pinVal = new JLabel("XXXX");
        pinVal.setFont(new Font("Arial", Font.BOLD, 16));
        pinVal.setBounds(350, 390, 100, 30);
        add(pinVal);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Arial", Font.BOLD, 16));
        services.setBounds(110, 440, 200, 30);
        add(services);

        JCheckBox atm = new JCheckBox("ATM CARD");
        atm.setFont(new Font("Arial", Font.BOLD, 14));
        atm.setBounds(100, 490, 150, 30);
        add(atm);

        JCheckBox internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Arial", Font.BOLD, 14));
        internet.setBounds(360, 490, 200, 30);
        add(internet);

        JCheckBox mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Arial", Font.BOLD, 14));
        mobile.setBounds(100, 540, 200, 30);
        add(mobile);

        JCheckBox email = new JCheckBox("EMAIL Alerts");
        email.setFont(new Font("Arial", Font.BOLD, 14));
        email.setBounds(360, 540, 200, 30);
        add(email);

        JCheckBox cheque = new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Arial", Font.BOLD, 14));
        cheque.setBounds(100, 590, 200, 30);
        add(cheque);

        JCheckBox eStm = new JCheckBox("E-Statement");
        eStm.setFont(new Font("Arial", Font.BOLD, 14));
        eStm.setBounds(360, 590, 200, 30);
        add(eStm);

        JCheckBox declaration = new JCheckBox("I hearby declare that  the above entered " +
                "details are correct to the best of my knowledge");
        declaration.setFont(new Font("Arial", Font.TYPE1_FONT, 12));
        declaration.setBounds(100, 660, 600, 30);
        declaration.setSelected(true);
        add(declaration);

        JButton submit = new JButton("Submit");
        submit.setBounds(250, 710, 100, 30);
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(420, 710, 100, 30);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        atm.addItemListener(this);
        internet.addItemListener(this);
        mobile.addItemListener(this);
        email.addItemListener(this);
        cheque.addItemListener(this);
        eStm.addItemListener(this);

        submit.addActionListener(e -> {
            String acctTypeVal = "";
            String error = "";
            if (!savingAcct.isSelected() && !fixedDepAcct.isSelected() && !currentAcct.isSelected()
                    && !recurringDepAcct.isSelected()){
                error = "Please select any account type!";
            }
            else {
                if (savingAcct.isSelected()){
                    acctTypeVal = savingAcct.getText();
                } else if (fixedDepAcct.isSelected()) {
                    acctTypeVal = fixedDepAcct.getText();
                } else if (currentAcct.isSelected()) {
                    acctTypeVal = currentAcct.getText();
                }
                else {
                    acctTypeVal = recurringDepAcct.getText();
                }
            }

            if (listOfServices.isEmpty()){
                error += "\nPlease select at least one service";
            }

            if (!declaration.isSelected()){
                error += "\nPlease check the declaration!";
            }

            if (error.equals("")){
                StringBuilder requiredServicesList = new StringBuilder();
                for (String service : listOfServices) {
                    requiredServicesList.append(service).append(" ");
                }
                String reqServices = requiredServicesList.toString();
                long num1, num2;
                String generateUUIDNo1 = String.format("%010d",new
                        BigInteger(UUID.randomUUID().toString().replace("-",""),16));
                String generateUUIDNo2 = String.format("%010d",new
                        BigInteger(UUID.randomUUID().toString().replace("-",""),16));
                num1 = Long.parseLong(generateUUIDNo1.substring( generateUUIDNo1.length() - 16));
                num2 = Long.parseLong(generateUUIDNo2.substring( generateUUIDNo2.length() - 4));

                boolean isAgreed = false;
                isAgreed = declaration.isSelected();
                SignupThreeDao.insertDetailsToSignupPageThree((int) num, acctTypeVal, num1, (int) num2,
                        reqServices, isAgreed);
                LoginDao lgn = new LoginDao();
                lgn.insertDetailsToLogin((int) num, num1, (int) num2);
                CustomerTransactionsDao ctd = new CustomerTransactionsDao();
                ctd.insertCustomerDetails((int) num, num1, (int) num2);
                String msg = "Card Number: " + num1 + "\nPIN: " + num2;
                JOptionPane.showMessageDialog(null, msg);
                new DepositAmtScreen((int) num, num1, (int) num2);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, error);
            }

        });

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setSize(800, 800);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().getClass() == JCheckBox.class){
            JCheckBox cb = (JCheckBox)e.getSource();
            if (e.getStateChange() == e.SELECTED){
                listOfServices.add(cb.getText());
            }
            else {
                listOfServices.remove(cb.getText());
            }
        }
    }

//    public static void main(String[] args){
//        new SignupPageThree(num);
//    }
}
