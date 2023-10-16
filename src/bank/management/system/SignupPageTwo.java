package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupPageTwo extends JFrame {
    public SignupPageTwo(long num){
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img = ic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel imgLabel = new JLabel(ic1);
        imgLabel.setBounds(180, 10, 100, 100);
        add(imgLabel);

        JLabel label1 = new JLabel("Page 2: Additional Details");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setBounds(310, 40, 250, 30);
        add(label1);

        JLabel label2 = new JLabel("Form No: " + num);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        label2.setBounds(680, 10, 100, 30);
        add(label2);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Arial", Font.BOLD, 16));
        religion.setBounds(140, 130, 100, 30);
        add(religion);

        String[] religions = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        JComboBox<String> religionsMenu = new JComboBox<>(religions);
        religionsMenu.setBounds(310, 130, 350, 30);
        add(religionsMenu);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Arial", Font.BOLD, 16));
        category.setBounds(140, 190, 100, 30);
        add(category);

        String[] categories = {"General", "OBC", "SC", "ST", "Other"};
        JComboBox<String> categoriesMenu = new JComboBox<>(categories);
        categoriesMenu.setBounds(310, 190, 350, 30);
        add(categoriesMenu);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Arial", Font.BOLD, 16));
        income.setBounds(140, 250, 100, 30);
        add(income);

        String[] incomes = {"Null", "<1,50,000", "<2,50,000",
                "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        JComboBox<String> incomeMenu = new JComboBox<>(incomes);
        incomeMenu.setBounds(310, 250, 350, 30);
        add(incomeMenu);

        JLabel qualification = new JLabel();
        String labelTxt = "<html>Education<br>Qualification:<html>";
        qualification.setText(labelTxt);
        qualification.setFont(new Font("Arial", Font.BOLD, 16));
        qualification.setBounds(140, 310, 100, 30);
        add(qualification);

        String[] qualifications = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        JComboBox<String> qualificationMenu = new JComboBox<>(qualifications);
        qualificationMenu.setBounds(310, 310, 350, 30);
        add(qualificationMenu);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Arial", Font.BOLD, 16));
        occupation.setBounds(140, 370, 100, 30);
        add(occupation);

        String[] occupations = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        JComboBox<String> occupationMenu = new JComboBox<>(occupations);
        occupationMenu.setBounds(310, 370, 350, 30);
        add(occupationMenu);

        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Arial", Font.BOLD, 16));
        panNo.setBounds(140, 430, 150, 30);
        add(panNo);

        JTextField panField = new JTextField();
        panField.setFont(new Font("Arial", Font.BOLD, 14));
        panField.setBounds(310, 430, 350, 30);
        add(panField);

        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Arial", Font.BOLD, 16));
        aadharNo.setBounds(140, 490, 150, 30);
        add(aadharNo);

        JTextField aadharField = new JTextField();
        aadharField.setFont(new Font("Arial", Font.BOLD, 14));
        aadharField.setBounds(310, 490, 350, 30);
        add(aadharField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Arial", Font.BOLD, 16));
        seniorCitizen.setBounds(140, 550, 150, 30);
        add(seniorCitizen);

        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton yes1 = new JRadioButton("Yes");
        yes1.setBounds(310, 550, 100, 30);
        JRadioButton no1 = new JRadioButton("No");
        no1.setBounds(430, 550, 100, 30);
        bg1.add(yes1);
        bg1.add(no1);
        add(yes1);
        add(no1);

        JLabel existingAcct = new JLabel("Existing Account:");
        existingAcct.setFont(new Font("Arial", Font.BOLD, 16));
        existingAcct.setBounds(140, 610, 150, 30);
        add(existingAcct);

        ButtonGroup bg2 = new ButtonGroup();
        JRadioButton yes2 = new JRadioButton("Yes");
        yes2.setBounds(310, 610, 100, 30);
        JRadioButton no2 = new JRadioButton("No");
        no2.setBounds(430, 610, 100, 30);
        bg2.add(yes2);
        bg2.add(no2);
        add(yes2);
        add(no2);

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(560, 680, 100, 30);
        nextBtn.setOpaque(true);
        nextBtn.setBorderPainted(false);
        nextBtn.setBackground(Color.BLACK);
        nextBtn.setForeground(Color.WHITE);
        add(nextBtn);

        nextBtn.addActionListener(e -> {
            String religionVal = String.valueOf(religionsMenu.getSelectedItem());
            String categoryVal = String.valueOf(categoriesMenu.getSelectedItem());
            String incomeVal = String.valueOf(incomeMenu.getSelectedItem());
            String qualificationVal = String.valueOf(qualificationMenu.getSelectedItem());
            String occupationVal = String.valueOf(occupationMenu.getSelectedItem());
            String panVal = panField.getText();
            String aadhaarVal = aadharField.getText();
            String error = "";
            if (!checkPanNum(panVal)){
                error += "Invalid Pan Number\n";
            }
            if (!checkAadhaarNum(aadhaarVal)){
                error += "Invalid Aadhaar Number\n";
            }
            if (!yes1.isSelected() && !no1.isSelected()){
                error += "Select Yes/No for the senior citizen option\n";
            }
            if (!yes2.isSelected() && !no2.isSelected()){
                error += "Select Yes/No for the existing account option\n";
            }

            if (error.equals("")){
                boolean isSeniorCitizen, hasExistingAcct;
                isSeniorCitizen = yes1.isSelected();
                hasExistingAcct = yes2.isSelected();
                SignupTwoDao.insertDetailsToSignupPageTwo((int) num, religionVal, categoryVal, incomeVal,
                        qualificationVal, occupationVal, panVal, aadhaarVal, isSeniorCitizen, hasExistingAcct);
                new SignupPageThree(num);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, error);
            }

        });

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
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

    public boolean checkPanNum(String panNum){
        String regex = "^([A-Z]{5}[0-9]{4}[A-Z]{1}$)";
        return checkField(panNum, regex);
    }

    public boolean checkAadhaarNum(String aadhaarNum){
        String regex = "^([^01]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4})$";
        return checkField(aadhaarNum, regex);
    }
}
