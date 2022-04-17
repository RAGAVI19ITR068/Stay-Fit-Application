/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Ragavi
 */
public class Register extends JFrame implements ActionListener {

    JButton btn, reset, cancel, verify, otpRef;
    JLabel first, last, userName, dob, age, email, city, state, pincode, password, reenter, old, mob, otp;
    SpinnerModel ageSpin;
    JSpinner ageField;
    JComboBox area;
    final JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8;
    JPanel reglab, regpan;
    JScrollPane scrollPane;
    int otpRand;

    Register() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\background-1.jpg");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1920, 1030);
        background.setLayout(null);
        add(background);

        Font f = new Font("Bradley Hand ITC", Font.BOLD, 70);
        JLabel head1 = new JLabel("STAY FIT");
        head1.setBounds(1280, 10, 1000, 100);
        head1.setFont(f);
        head1.setForeground(new Color(255, 255, 255));
        background.add(head1);
        
        JLabel head2 = new JLabel("APPLICATION");
        head2.setBounds(1200, 90, 1000, 100);
        head2.setFont(f);
        head2.setForeground(new Color(255, 255, 255));
        background.add(head2);

        reglab = new JPanel();

        JLabel title = new JLabel("REGISTRATION FORM");
        Font f1 = new Font("Bradley Hand ITC", Font.BOLD, 48);
        title.setBounds(160, 20, 700, 35);
        title.setBackground(new Color(36, 31, 30));
        title.setForeground(new Color(255, 255, 255));
        title.setFont(f1);
        reglab.add(title);

        reglab.setBackground(new Color(36, 31, 30));
        reglab.setLayout(null);
        reglab.setBounds(980, 190, 900, 80);
        reglab.setVisible(true);
        background.add(reglab);

        regpan = new JPanel();
        Font f2 = new Font("Lucida Calligraphy", Font.BOLD, 23);
        Font f3 = new Font("Lucida Calligraphy", Font.PLAIN, 18);

        first = new JLabel("First Name : ");
        first.setBounds(110, 20, 200, 40);
        first.setBackground(new Color(182, 230, 179));
        first.setForeground(new Color(36, 31, 30));
        first.setFont(f2);
        regpan.add(first);

        textField1 = new JTextField(20);
        textField1.setBounds(310, 20, 450, 40);
        textField1.setBackground(new Color(36, 31, 30));
        textField1.setForeground(new Color(255, 255, 255));
        textField1.setFont(f3);
        textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        regpan.add(textField1);

        last = new JLabel(" Last Name : ");
        last.setBounds(110, 80, 200, 40);
        last.setBackground(new Color(182, 230, 179));
        last.setForeground(new Color(36, 31, 30));
        last.setFont(f2);
        regpan.add(last);

        textField2 = new JTextField(20);
        textField2.setBounds(310, 80, 450, 40);
        textField2.setBackground(new Color(36, 31, 30));
        textField2.setForeground(new Color(255, 255, 255));
        textField2.setFont(f3);
        textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        regpan.add(textField2);

        age = new JLabel("Age : ");
        age.setBounds(110, 140, 150, 40);
        age.setBackground(new Color(182, 230, 179));
        age.setForeground(new Color(36, 31, 30));
        age.setFont(f2);
        regpan.add(age);

        ageSpin = new SpinnerNumberModel(18, 18, 58, 1);
        ageField = new JSpinner(ageSpin);
        ageField.setBounds(210, 140, 100, 40);
        ageField.setBackground(new Color(36, 31, 30));
        ageField.setForeground(new Color(255, 255, 255));
        ageField.setFont(f3);
        regpan.add(ageField);

        city = new JLabel();
        city.setText("     City : ");
        city.setBounds(390, 140, 150, 40);
        city.setBackground(new Color(182, 230, 179));
        city.setForeground(new Color(36, 31, 30));
        city.setFont(f2);
        regpan.add(city);

        String dist[] = {"Chennai", "Coimbatore", "Tiruppur", "Erode", "Namakkal", "Trichy"};
        area = new JComboBox(dist);
        area.setBounds(560, 140, 200, 40);
        area.setBackground(new Color(36, 31, 30));
        area.setForeground(new Color(255, 255, 255));
        area.setFont(f3);
        area.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regpan.add(area);

        email = new JLabel("       E-mail :   ");
        email.setBounds(110, 200, 200, 40);
        email.setBackground(new Color(182, 230, 179));
        email.setForeground(new Color(36, 31, 30));
        email.setFont(f2);
        regpan.add(email);

        textField3 = new JTextField("example@gmail.com");
        textField3.setBounds(310, 200, 450, 40);
        textField3.setBackground(new Color(36, 31, 30));
        textField3.setForeground(new Color(255, 255, 255));
        textField3.setFont(f3);
        textField3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        regpan.add(textField3);

        mob = new JLabel("      Mobile :    ");
        mob.setBounds(110, 260, 200, 40);
        mob.setBackground(new Color(182, 230, 179));
        mob.setForeground(new Color(36, 31, 30));
        mob.setFont(f2);
        regpan.add(mob);

        textField4 = new JTextField("+91-");
        textField4.setBounds(310, 260, 450, 40);
        textField4.setBackground(new Color(36, 31, 30));
        textField4.setForeground(new Color(255, 255, 255));
        textField4.setFont(f3);
        textField4.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        regpan.add(textField4);

        verify = new JButton("VERIFY");
        verify.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        verify.setBounds(230, 330, 500, 50);
        verify.setBackground(new Color(36, 31, 30));
        verify.setForeground(new Color(255, 255, 255));
        verify.setFont(f3);
        regpan.add(verify);
        verify.addActionListener(this);

        otp = new JLabel("   OTP :    ");
        otp.setBounds(110, 410, 180, 40);
        otp.setBackground(new Color(182, 230, 179));
        otp.setForeground(new Color(36, 31, 30));
        otp.setFont(f2);
//        regpan.add(otp);

        textField5 = new JTextField(6);
        textField5.setBounds(270, 410, 420, 40);
        textField5.setBackground(new Color(36, 31, 30));
        textField5.setForeground(new Color(255, 255, 255));
        textField5.setFont(f3);
        textField5.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//        regpan.add(textField5);

        ImageIcon otpIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\arrow.png");
        otpRef = new JButton(otpIcon);
        otpRef.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        otpRef.setBounds(690, 410, 100, 40);
        otpRef.setBackground(new Color(36, 31, 30));
        otpRef.setForeground(new Color(255, 255, 255));
        otpRef.setFont(f3);
//        regpan.add(otpRef);
        otpRef.addActionListener(this);

        userName = new JLabel(" Username : ");
        userName.setBounds(110, 480, 200, 40);
        userName.setBackground(new Color(182, 230, 179));
        userName.setForeground(new Color(36, 31, 30));
        userName.setFont(f2);
//        regpan.add(userName);

        textField6 = new JTextField(10);
        textField6.setBounds(310, 480, 450, 40);
        textField6.setBackground(new Color(36, 31, 30));
        textField6.setForeground(new Color(255, 255, 255));
        textField6.setFont(f3);
        textField6.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//        regpan.add(textField6);

        password = new JLabel("  Password : ");
        password.setBounds(110, 540, 200, 40);
        password.setBackground(new Color(182, 230, 179));
        password.setForeground(new Color(36, 31, 30));
        password.setFont(f2);
//        regpan.add(password);

        textField7 = new JPasswordField(20);
        textField7.setBounds(310, 540, 450, 40);
        textField7.setBackground(new Color(36, 31, 30));
        textField7.setForeground(new Color(255, 255, 255));
        textField7.setFont(f3);
        textField7.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//        regpan.add(textField7);

        reenter = new JLabel("   Re-enter : ");
        reenter.setBounds(110, 600, 200, 40);
        reenter.setBackground(new Color(182, 230, 179));
        reenter.setForeground(new Color(36, 31, 30));
        reenter.setFont(f2);
//        regpan.add(reenter);

        textField8 = new JPasswordField(20);
        textField8.setBounds(310, 600, 450, 40);
        textField8.setBackground(new Color(36, 31, 30));
        textField8.setForeground(new Color(255, 255, 255));
        textField8.setFont(f3);
        textField8.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//        regpan.add(textField8);

        cancel = new JButton("CANCEL");
        cancel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        cancel.setBounds(230, 410, 180, 50);
        cancel.setBackground(new Color(36, 31, 30));
        cancel.setForeground(new Color(255, 255, 255));
        cancel.setFont(f3);
        regpan.add(cancel);
        cancel.addActionListener(this);

        reset = new JButton("RESET");
        reset.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        reset.setBounds(510, 410, 180, 50);
        reset.setBackground(new Color(36, 31, 30));
        reset.setForeground(new Color(255, 255, 255));
        reset.setFont(f3);
        regpan.add(reset);
        reset.addActionListener(this);

        btn = new JButton("REGISTER");
        btn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btn.setBounds(560, 670, 180, 50);
        btn.setBackground(new Color(36, 31, 30));
        btn.setForeground(new Color(255, 255, 255));
        btn.setFont(f3);
//        regpan.add(btn);
        btn.addActionListener(this);

        old = new JLabel("Old User?  Login here ... ");
        old.setBounds(320, 490, 500, 40);
        old.setBackground(new Color(182, 230, 179));
        old.setForeground(new Color(36, 31, 30));
        old.setFont(f2);
        old.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regpan.add(old);
        old.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Login log = new Login();
                log.setVisible(true);
                setVisible(false);

            }
        });

        regpan.setBackground(new Color(182, 230, 179));
        regpan.setLayout(null);
        regpan.setBounds(980, 270, 900, 580);
        regpan.setVisible(true);
        background.add(regpan);
        

//        scrollPane = new JScrollPane(this,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBounds(980, 330, 900, 580);
//        add(scrollPane);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRATION FORM");
        setSize(1920, 1030);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int flag = 0, mobFlag = 0, emailFlag = 0;
        if (e.getSource() == verify) {
            String email = textField3.getText();
            String mobile = textField4.getText();
            if ((ValidateEmail.isValid(email)) && (ValidateMobile.isValid(mobile))) {
                if (ValidateEmail.isAvail(email, this)) {
                    JOptionPane.showMessageDialog(this, "This email id was alreay registered.");
                    emailFlag = 1;
                }
                if (ValidateMobile.isAvail(mobile, this)) {
                    JOptionPane.showMessageDialog(this, "This mobile number was alreay registered.");
                    mobFlag = 1;
                }
                if (mobFlag == 0 && emailFlag == 0) {
                    String name = textField1.getText() + " " + textField2.getText();
                    Random rand = new Random();
                    otpRand = rand.nextInt(999999);
                    if (Otp.sendSms(name, otpRand, ValidateMobile.mobile, this)) {
                        flag = 1;
                    }
                    if (flag == 1) {
                        regpan.add(otp);
                        regpan.add(textField5);
                        regpan.add(otpRef);
                        cancel.setBounds(230, 480, 180, 50);
                        reset.setBounds(510, 480, 180, 50);
                        old.setBounds(320, 560, 500, 40);
                        regpan.setBounds(980, 270, 900, 620);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email id or mobile number...\n\n"
                        + "E-mail :\n\t"
                        + "First part should be string\n\t"
                        + "Second part is @\n\t"
                        + "Third part is a domain name\n\t\t"
                        + "eg : gmail.com, yahoo.com, kongu.edu, kongu.ac.in, abc.co.in"
                        + "Mobile :\n\t"
                        + "Without country code :\n\t\tOnly 10 digits - should starts with 6-9.\n\n\t"
                        + "With country code :\n\t\tCountry code : 0 or +91.\n\t\t"
                        + "If you use 0 then 10 digits shoul be countinued after 0 without any special characters.\n\t\t"
                        + "10 digits mobile number should be starts with 6-9.\n\t\t"
                        + "If you use +91 then enter - or space and 10 digits should be countinued after that.");
            }
        }
        if (e.getSource() == otpRef) {
            if (Integer.parseInt(textField5.getText()) == otpRand) {
                regpan.add(userName);
                regpan.add(textField6);
                regpan.add(password);
                regpan.add(textField7);
                regpan.add(reenter);
                regpan.add(textField8);
                cancel.setBounds(110, 670, 180, 50);
                reset.setBounds(335, 670, 180, 50);
                regpan.add(btn);
                old.setBounds(320, 750, 500, 40);
                regpan.setBounds(980, 270, 900, 820);
//                scrollPane.setBounds(980, 350, 900, 860);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP");
                System.out.println(otpRef);
            }
        }
        if (e.getSource() == btn) {

            Statement stmt = null;
            Connection myConn = null;

            String uid = "U - " + String.format("%04d", new Random().nextInt(10000));
            String first = textField1.getText();
            String last = textField2.getText();
            String age = ageField.getValue().toString();
            String city = area.getSelectedItem().toString();
            String emailValue = textField3.getText();
            String mobileValue = textField4.getText();
            String userValue = textField6.getText();
            String passValue = textField7.getText();
            String reenterValue = textField8.getText();

            try {
                if (userValue.length() <= 10) {
                    if (UserAvailable.isAvail(userValue, this)) {
                        JOptionPane.showMessageDialog(this, "This username is alreay available...\nPlease enter a different one...");
                    } else {
                        if ((passValue.length() == 8) && (reenterValue.length() == 8)) {
                            if (passValue.equals(reenterValue)) {
                                myConn = MySQLConnection.getConnection();

                                String mySqlQuery = "INSERT INTO USERS(UserID, FirstName, LastName, Age, City, Email, Mobile, Username, Password) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                                PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
                                preparedStatement.setString(1, uid);
                                preparedStatement.setString(2, first);
                                preparedStatement.setString(3, last);
                                preparedStatement.setString(4, age);
                                preparedStatement.setString(5, city);
                                preparedStatement.setString(6, emailValue);
                                preparedStatement.setString(7, mobileValue);
                                preparedStatement.setString(8, userValue);
                                preparedStatement.setString(9, passValue);
                                preparedStatement.execute();

                                JOptionPane.showMessageDialog(this, "Hello, " + userValue + " ...\nYou have Registered Successfully!...");

                                Operation.isLogin(userValue, passValue, this);
                                Index page = new Index();
                                page.setVisible(true);
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(this, "Password and Re-enter password should be match");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Password length should be 8 characters");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username should be less than or equal to 10 characters.");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this, "Something went wrong during insertion: " + exception);
                System.out.println(exception);
            } finally {
                try {
                    if (stmt != null) {
                        myConn.close();
                    }
                } catch (SQLException se) {
                    System.out.println(se);
                }
                try {
                    if (myConn != null) {
                        myConn.close();
                    }
                } catch (SQLException se) {
                    System.out.println(se);
                }
            }
        }

        if (e.getSource() == cancel) {
            Login log = new Login();
            log.setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == reset) {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("example@gmai.com");
            textField4.setText("+91-");
            textField5.setText("");
            textField6.setText("");
            textField7.setText("");
            ageField.setValue(ageSpin);
            area.setSelectedIndex(0);
        }

    }
}
