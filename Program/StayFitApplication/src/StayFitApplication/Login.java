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
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Ragavi
 */
public class Login extends JFrame implements ActionListener {

    JButton sub, reset, cancel, verify, otpRef;
    JLabel name, email, mobile, password, newUser, otp;
    final JTextField textField1, textField2, textField3, textField4, textField5;
    JPanel loginlab, loginpan;
    int otpRand;

    Login() {

        ImageIcon icon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\background-1.jpg");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1920, 1030);
        background.setLayout(null);
        add(background);

        Font f = new Font("Bradley Hand ITC", Font.BOLD, 70);
        JLabel head1 = new JLabel("STAY FIT");
        head1.setBounds(1280, 50, 1000, 100);
        head1.setFont(f);
        head1.setForeground(new Color(255, 255, 255));
        background.add(head1);

        JLabel head2 = new JLabel("APPLICATION");
        head2.setBounds(1200, 120, 1000, 100);
        head2.setFont(f);
        head2.setForeground(new Color(255, 255, 255));
        background.add(head2);

        loginlab = new JPanel();

        JLabel title = new JLabel("LOGIN FORM");
        Font f1 = new Font("Bradley Hand ITC", Font.BOLD, 48);
        title.setBounds(300, 30, 500, 40);
        title.setBackground(new Color(36, 31, 30));
        title.setForeground(new Color(255, 255, 255));
        title.setFont(f1);
        loginlab.add(title);

        loginlab.setBackground(new Color(36, 31, 30));
        loginlab.setLayout(null);
        loginlab.setBounds(980, 220, 900, 100);
        loginlab.setVisible(true);
        background.add(loginlab);

        loginpan = new JPanel();
        Font f2 = new Font("Lucida Calligraphy", Font.BOLD, 23);
        Font f3 = new Font("Lucida Calligraphy", Font.PLAIN, 18);

        name = new JLabel();
        name.setText(" Username : ");
        name.setBounds(110, 40, 200, 40);
        name.setBackground(new Color(182, 230, 179));
        name.setForeground(new Color(36, 31, 30));
        name.setFont(f2);
        loginpan.add(name);

        textField1 = new JTextField(25);
        textField1.setBounds(310, 40, 450, 40);
        textField1.setBackground(new Color(36, 31, 30));
        textField1.setForeground(new Color(255, 255, 255));
        textField1.setFont(f3);
        textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        loginpan.add(textField1);

        email = new JLabel();
        email.setText("     E-mail : ");
        email.setBounds(110, 100, 200, 40);
        email.setBackground(new Color(182, 230, 179));
        email.setForeground(new Color(36, 31, 30));
        email.setFont(f2);
        loginpan.add(email);

        textField2 = new JTextField("example@gmail.com");
        textField2.setBounds(310, 100, 450, 40);
        textField2.setBackground(new Color(36, 31, 30));
        textField2.setForeground(new Color(255, 255, 255));
        textField2.setFont(f3);
        textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        loginpan.add(textField2);

        mobile = new JLabel();
        mobile.setText("    Mobile : ");
        mobile.setBounds(110, 160, 200, 40);
        mobile.setBackground(new Color(182, 230, 179));
        mobile.setForeground(new Color(36, 31, 30));
        mobile.setFont(f2);
        loginpan.add(mobile);

        textField3 = new JTextField("+91-");
        textField3.setBounds(310, 160, 450, 40);
        textField3.setBackground(new Color(36, 31, 30));
        textField3.setForeground(new Color(255, 255, 255));
        textField3.setFont(f3);
        textField3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        loginpan.add(textField3);

        password = new JLabel();
        password.setText("Password : ");
        password.setBounds(110, 220, 200, 40);
        password.setBackground(new Color(182, 230, 179));
        password.setForeground(new Color(36, 31, 30));
        password.setFont(f2);
        loginpan.add(password);

        textField4 = new JPasswordField(25);
        textField4.setBounds(310, 220, 450, 40);
        textField4.setBackground(new Color(36, 31, 30));
        textField4.setForeground(new Color(255, 255, 255));
        textField4.setFont(f3);
        textField4.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        loginpan.add(textField4);

        verify = new JButton("VERIFY");
        verify.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        verify.setBounds(210, 300, 500, 50);
        verify.setBackground(new Color(36, 31, 30));
        verify.setForeground(new Color(255, 255, 255));
        verify.setFont(f3);
        loginpan.add(verify);
        verify.addActionListener(this);

        otp = new JLabel("   OTP :  ");
        otp.setBounds(110, 420, 180, 40);
        otp.setBackground(new Color(182, 230, 179));
        otp.setForeground(new Color(36, 31, 30));
        otp.setFont(f2);
//        regpan.add(otp);

        textField5 = new JTextField(6);
        textField5.setBounds(270, 420, 420, 40);
        textField5.setBackground(new Color(36, 31, 30));
        textField5.setForeground(new Color(255, 255, 255));
        textField5.setFont(f3);
        textField5.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//        regpan.add(textField5);

        ImageIcon otpIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\arrow.png");
        otpRef = new JButton(otpIcon);
        otpRef.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        otpRef.setBounds(690, 420, 100, 40);
        otpRef.setBackground(new Color(36, 31, 30));
        otpRef.setForeground(new Color(255, 255, 255));
        otpRef.setFont(f3);
//        regpan.add(otpRef);
        otpRef.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        cancel.setBounds(230, 400, 180, 50);
        cancel.setBackground(new Color(36, 31, 30));
        cancel.setForeground(new Color(255, 255, 255));
        cancel.setFont(f3);
        loginpan.add(cancel);
        cancel.addActionListener(this);

        reset = new JButton("RESET");
        reset.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        reset.setBounds(510, 400, 180, 50);
        reset.setBackground(new Color(36, 31, 30));
        reset.setForeground(new Color(255, 255, 255));
        reset.setFont(f3);
        loginpan.add(reset);
        reset.addActionListener(this);

        newUser = new JLabel();
        newUser.setText(" Create a new account here ");
        newUser.setBounds(280, 500, 500, 40);
        newUser.setBackground(new Color(182, 230, 179));
        newUser.setForeground(new Color(36, 31, 30));
        newUser.setFont(f2);
        newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginpan.add(newUser);
        newUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Register user_reg = new Register();
                user_reg.setVisible(true);
                setVisible(false);

            }
        });

        loginpan.setBackground(new Color(182, 230, 179));
        loginpan.setLayout(null);
        loginpan.setBounds(980, 320, 900, 540);
        loginpan.setVisible(true);
        background.add(loginpan);

//        JScrollPane scrollPane = new JScrollPane(loginpan,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBounds(980, 350, 900, 540);
//        background.add(scrollPane);
        setSize(1920, 1030);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setTitle("LOGIN FORM");
    }

    public void actionPerformed(ActionEvent e) {
        int flag = 0, mobFlag = 0, emailFlag = 0;
        if (e.getSource() == verify) {
            String username = textField1.getText();
            String email = textField2.getText();
            String mobile = textField3.getText();
            String pass = textField4.getText();
            if (Operation.isLogin(username, pass, this)) {
                if ((ValidateEmail.isValid(email)) && (ValidateMobile.isValid(mobile))) {
                    if (!(ValidateEmail.isAvail(email, this))) {
                        JOptionPane.showMessageDialog(this, "Incorrect email id.");
                        emailFlag = 1;
                    }
                    if (!(ValidateMobile.isAvail(mobile, this))) {
                        JOptionPane.showMessageDialog(this, "Incorrect mobile number.");
                        mobFlag = 1;
                    }
                    if (mobFlag == 0 && emailFlag == 0) {
                        String name = LoginSession.Firstname + " " + LoginSession.Lastname;
                        Random rand = new Random();
                        otpRand = rand.nextInt(999999);
                        if (Otp.sendSms(name, otpRand, ValidateMobile.mobile, this)) {
                            flag = 1;
                        }
                        if (flag == 1) {
                            loginpan.add(otp);
                            loginpan.add(textField5);
                            loginpan.add(otpRef);
                            cancel.setBounds(230, 500, 180, 50);
                            reset.setBounds(510, 500, 180, 50);
                            newUser.setBounds(280, 600, 500, 40);
                            loginpan.setBounds(980, 320, 900, 640);
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
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password.");
            }
        }
        if (e.getSource() == otpRef) {
            if (Integer.parseInt(textField5.getText()) == otpRand) {
                JOptionPane.showMessageDialog(this, "You have logged in successfully!...");
                Index page = new Index();
                page.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP");
            }
        }

        if (e.getSource() == reset) {
            textField1.setText("");
            textField2.setText("example@gmail.com");
            textField3.setText("+91-");
            textField4.setText("");
        }
        if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        Login log = new Login();
    }
}
