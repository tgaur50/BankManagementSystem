package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.math.BigInteger;
import java.util.UUID;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupPageOne extends JFrame {
    public SignupPageOne(){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img = ic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic1);
        imgLabel.setBounds(30, 10, 100, 100);
        add(imgLabel);

        String generateUUIDNo = String.format("%010d",new
                BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        long num = Integer.parseInt(generateUUIDNo.substring( generateUUIDNo.length() - 4));


        JLabel label1 = new JLabel("APPLICATION FORM NUMBER NO. " + num);
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        label1.setBounds(150, 40, 600, 30);
        add(label1);

        JLabel label2 = new JLabel("Page 1: Personal Details");
        label2.setFont(new Font("Arial", Font.BOLD, 18));
        label2.setBounds(300, 90, 250, 30);
        add(label2);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setBounds(90, 150, 100, 30);
        add(name);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        nameField.setBounds(310, 150, 350, 30);
        add(nameField);

        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Arial", Font.BOLD, 16));
        fatherName.setBounds(90, 200, 200, 30);
        add(fatherName);

        JTextField fNameField = new JTextField();
        fNameField.setFont(new Font("Arial", Font.BOLD, 14));
        fNameField.setBounds(310, 200, 350, 30);
        add(fNameField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial", Font.BOLD, 16));
        dob.setBounds(90, 250, 200, 30);
        add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(310, 250, 350, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 16));
        gender.setBounds(90, 300, 100, 30);
        add(gender);

        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(310, 300, 100, 30);
        bg1.add(male);
        add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(430, 300, 100, 30);
        bg1.add(female);
        add(female);

        JLabel emailAddr = new JLabel("Email Address:");
        emailAddr.setFont(new Font("Arial", Font.BOLD, 16));
        emailAddr.setBounds(90, 350, 200, 30);
        add(emailAddr);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.BOLD, 14));
        emailField.setBounds(310, 350, 350, 30);
        add(emailField);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Arial", Font.BOLD, 16));
        maritalStatus.setBounds(90, 400, 200, 30);
        add(maritalStatus);

        ButtonGroup bg2 = new ButtonGroup();
        JRadioButton married = new JRadioButton("Married");
        married.setBounds(310, 400, 110, 30);
        JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 400, 110, 30);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(550, 400, 110, 30);
        bg2.add(married);
        bg2.add(unmarried);
        bg2.add(other);
        add(married);
        add(unmarried);
        add(other);

        JLabel addr = new JLabel("Address:");
        addr.setFont(new Font("Arial", Font.BOLD, 16));
        addr.setBounds(90, 450, 100, 30);
        add(addr);

        JTextField addrField = new JTextField();
        addrField.setFont(new Font("Arial", Font.BOLD, 14));
        addrField.setBounds(310, 450, 350, 30);
        add(addrField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD, 16));
        city.setBounds(90, 500, 100, 30);
        add(city);

        JTextField cityField = new JTextField();
        cityField.setFont(new Font("Arial", Font.BOLD, 14));
        cityField.setBounds(310, 500, 350, 30);
        add(cityField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Arial", Font.BOLD, 16));
        pincode.setBounds(90, 550, 200, 30);
        add(pincode);

        JTextField pincodeField = new JTextField();
        pincodeField.setFont(new Font("Arial", Font.BOLD, 14));
        pincodeField.setBounds(310, 550, 350, 30);
        add(pincodeField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Arial", Font.BOLD, 16));
        state.setBounds(90, 600, 100, 30);
        add(state);

        JTextField stateField = new JTextField();
        stateField.setFont(new Font("Arial", Font.BOLD, 14));
        stateField.setBounds(310, 600, 350, 30);
        add(stateField);

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(560, 670, 100, 30);
        nextBtn.setOpaque(true);
        nextBtn.setBorderPainted(false);
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        add(nextBtn);

        nextBtn.addActionListener(e -> {
            String nameVal = nameField.getText();
            String fNameVal = fNameField.getText();
            String dobVal = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String genderVal = null, martialStatusVal = null;
            String emailVal = emailField.getText();
            String addrVal = addrField.getText();
            String cityVal = cityField.getText();
            String pincodeVal = pincodeField.getText();
            String stateVal = stateField.getText();
            String error = "";
            if (!checkNames(nameVal)){
                error += "Invalid Name\n";
            }
            if (!checkNames(fNameVal)){
                error += "Invalid Father Name\n";
            }
            if (!male.isSelected() && !female.isSelected()){
                error += "Please select any gender!\n";
            }
            if (!checkEmail(emailVal)){
                error += "Invalid Email\n";
            }
            if (!married.isSelected() && !unmarried.isSelected() && !other.isSelected()){
                error += "Please select any marital status!\n";
            }
            if (!checkAddress(addrVal)){
                error += "Invalid Address\n";
            }
            if (!checkAddress(cityVal)){
                error += "Invalid City\n";
            }
            if (!checkPinCode(pincodeVal)){
                error += "Invalid Pin Code\n";
            }
            if (!checkAddress(stateVal)){
                error += "Invalid State\n";
            }
            if (error.equals("")){
                genderVal = male.isSelected() ? "Male" : "Female";
                if (married.isSelected()){
                    martialStatusVal = married.getText();
                } else if (unmarried.isSelected()) {
                    martialStatusVal = unmarried.getText();
                }
                else {
                    martialStatusVal = other.getText();
                }
                SignUpOneDao.insertDetailsToSignupOne((int) num, nameVal, fNameVal,
                        dobVal, genderVal, emailVal, martialStatusVal, addrVal, cityVal,
                        pincodeVal, stateVal);
                new SignupPageTwo(num);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, error);
            }

        });

        setTitle("NEW ACCOUNT APPLICATION FORM");
        setSize(800, 800);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public boolean checkField(String str, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public boolean checkNames(String custName){
        String regex = "^([A-z\\'\\.\\-]*(\\s))*[A-z\\'\\.\\-]+$";
        return checkField(custName, regex);
    }

    public  boolean checkEmail(String email){
        String regex = "^([A-z]{1}[A-z0-9._-]+)@[A-z]{1}[A-z0-9._-]*[A-z0-9]+\\.[A-z]{2,}$";
        return checkField(email, regex);
    }

    public boolean checkAddress(String addr){
        String regex = "^([A-z0-9\\.\\_\\-\\'\\,]*(\\s))*[A-z0-9\\.\\_\\-\\'\\,]+$";
        return checkField(addr, regex);
    }

    public  boolean checkPinCode(String pincode){
        String regex = "^[0-9]{6}";
        return checkField(pincode, regex);
    }
}
