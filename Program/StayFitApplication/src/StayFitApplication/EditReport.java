/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Ragavi
 */
public class EditReport extends JFrame implements ActionListener {

    JButton sub, reset;
    JLabel weight, height, thyroid, cholestrol, bp, diabetes, pcod, back;
    JTextField textField1, textField2;
    JPanel reportlab, reportpan;
    JComboBox catThyroid, catBP, catDiabetes, catPcod, catCholestrol;
    ButtonGroup tbg, bpbg, dbg, pcbg, cbg;

    EditReport() {

        ImageIcon icon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\heartBeat.jpg");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1920, 1030);
        background.setLayout(null);
        add(background);

        Font f = new Font("Bradley Hand ITC", Font.BOLD, 70);
        JLabel head1 = new JLabel("STAY FIT APPLICATION");
        head1.setBounds(140, 0, 1000, 100);
        head1.setFont(f);
        head1.setForeground(new Color(255, 255, 255));
        background.add(head1);

        reportlab = new JPanel();

        ImageIcon backIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\back-arrow2.png");
        back = new JLabel(backIcon);
        back.setBounds(50, 20, 60, 60);
        back.setBackground(new Color(36, 31, 30));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportlab.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Index page = new Index();
                setVisible(false);
                page.setVisible(true);
            }
        });

        JLabel title = new JLabel("HEALTH REPORT FORM");
        Font f1 = new Font("Bradley Hand ITC", Font.BOLD, 48);
        title.setBounds(250, 30, 500, 40);
        title.setBackground(new Color(36, 31, 30));
        title.setForeground(new Color(255, 255, 255));
        title.setFont(f1);
        reportlab.add(title);

        reportlab.setBackground(new Color(36, 31, 30));
        reportlab.setLayout(null);
        reportlab.setBounds(150, 100, 900, 100);
        reportlab.setVisible(true);
        background.add(reportlab);

        reportpan = new JPanel();
        Font f2 = new Font("Lucida Calligraphy", Font.BOLD, 23);
        Font f3 = new Font("Lucida Calligraphy", Font.PLAIN, 18);

        weight = new JLabel();
        weight.setText(" Weight : ");
        weight.setBounds(110, 40, 200, 40);
        weight.setBackground(new Color(182, 230, 179));
        weight.setForeground(new Color(36, 31, 30));
        weight.setFont(f2);
        reportpan.add(weight);

        textField1 = new JTextField(ReportDetails.Weight);
        textField1.setBounds(310, 40, 450, 40);
        textField1.setBackground(new Color(36, 31, 30));
        textField1.setForeground(new Color(255, 255, 255));
        textField1.setFont(f3);
        textField1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        reportpan.add(textField1);

        height = new JLabel();
        height.setText(" Height : ");
        height.setBounds(110, 100, 200, 40);
        height.setBackground(new Color(182, 230, 179));
        height.setForeground(new Color(36, 31, 30));
        height.setFont(f2);
        reportpan.add(height);

        textField2 = new JTextField(ReportDetails.Height);
        textField2.setBounds(310, 100, 450, 40);
        textField2.setBackground(new Color(36, 31, 30));
        textField2.setForeground(new Color(255, 255, 255));
        textField2.setFont(f3);
        textField2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        reportpan.add(textField2);

        thyroid = new JLabel();
        thyroid.setText(" Thyroid : ");
        thyroid.setBounds(110, 160, 200, 40);
        thyroid.setBackground(new Color(182, 230, 179));
        thyroid.setForeground(new Color(36, 31, 30));
        thyroid.setFont(f2);
        reportpan.add(thyroid);

        String thyro[] = {"Normal", "Hypothyroidism", "Hyperthyroidism"};
        catThyroid = new JComboBox(thyro);
        catThyroid.setSelectedItem(ReportDetails.Thyroid);
        catThyroid.setBounds(310, 160, 300, 30);
        catThyroid.setBackground(new Color(36, 31, 30));
        catThyroid.setForeground(new Color(255, 255, 255));
        catThyroid.setFont(f3);
        catThyroid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportpan.add(catThyroid);

        bp = new JLabel();
        bp.setText("BP : ");
        bp.setBounds(110, 240, 200, 40);
        bp.setBackground(new Color(182, 230, 179));
        bp.setForeground(new Color(36, 31, 30));
        bp.setFont(f2);
        reportpan.add(bp);

        String bloodpress[] = {"Normal", "High BP", "Low BP"};
        catBP = new JComboBox(bloodpress);
        catBP.setSelectedItem(ReportDetails.BP);
        catBP.setBounds(310, 240, 300, 30);
        catBP.setBackground(new Color(36, 31, 30));
        catBP.setForeground(new Color(255, 255, 255));
        catBP.setFont(f3);
        catBP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportpan.add(catBP);

        diabetes = new JLabel();
        diabetes.setText("Diabetes : ");
        diabetes.setBounds(110, 320, 200, 40);
        diabetes.setBackground(new Color(182, 230, 179));
        diabetes.setForeground(new Color(36, 31, 30));
        diabetes.setFont(f2);
        reportpan.add(diabetes);

        String sugar[] = {"Normal", "High glucose level", "Low glucose level"};
        catDiabetes = new JComboBox(sugar);
        catDiabetes.setSelectedItem(ReportDetails.Diabetes);
        catDiabetes.setBounds(310, 320, 300, 30);
        catDiabetes.setBackground(new Color(36, 31, 30));
        catDiabetes.setForeground(new Color(255, 255, 255));
        catDiabetes.setFont(f3);
        catDiabetes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportpan.add(catDiabetes);

        pcod = new JLabel();
        pcod.setText("    PCOD : ");
        pcod.setBounds(110, 400, 200, 40);
        pcod.setBackground(new Color(182, 230, 179));
        pcod.setForeground(new Color(36, 31, 30));
        pcod.setFont(f2);
        reportpan.add(pcod);

        String sn1[] = {"Yes", "NO"};
        catPcod = new JComboBox(sn1);
        catPcod.setSelectedItem(ReportDetails.PCOD);
        catPcod.setBounds(310, 400, 300, 30);
        catPcod.setBackground(new Color(36, 31, 30));
        catPcod.setForeground(new Color(255, 255, 255));
        catPcod.setFont(f3);
        catPcod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportpan.add(catPcod);

        cholestrol = new JLabel();
        cholestrol.setText(" Cholestrol : ");
        cholestrol.setBounds(110, 480, 200, 40);
        cholestrol.setBackground(new Color(182, 230, 179));
        cholestrol.setForeground(new Color(36, 31, 30));
        cholestrol.setFont(f2);
        reportpan.add(cholestrol);

        String sn2[] = {"Yes", "NO"};
        catCholestrol = new JComboBox(sn2);
        catCholestrol.setSelectedItem(ReportDetails.Cholestrol);
        catCholestrol.setBounds(310, 480, 300, 30);
        catCholestrol.setBackground(new Color(36, 31, 30));
        catCholestrol.setForeground(new Color(255, 255, 255));
        catCholestrol.setFont(f3);
        catCholestrol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportpan.add(catCholestrol);

        reset = new JButton("RESET");
        reset.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        reset.setBounds(230, 600, 180, 50);
        reset.setBackground(new Color(36, 31, 30));
        reset.setForeground(new Color(255, 255, 255));
        reset.setFont(f3);
        reportpan.add(reset);
        reset.addActionListener(this);

        sub = new JButton("SUBMIT");
        sub.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        sub.setBounds(510, 600, 180, 50);
        sub.setBackground(new Color(36, 31, 30));
        sub.setForeground(new Color(255, 255, 255));
        sub.setFont(f3);
        reportpan.add(sub);
        sub.addActionListener(this);

        reportpan.setBackground(new Color(182, 230, 179));
        reportpan.setLayout(null);
        reportpan.setBounds(150, 200, 900, 750);
        reportpan.setVisible(true);
        background.add(reportpan);

        setSize(1920, 1030);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setTitle("HEALTH REPORT FORM");
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            textField1.setText(ReportDetails.Weight);
            textField2.setText(ReportDetails.Height);
            catThyroid.setSelectedItem(ReportDetails.Thyroid);
            catBP.setSelectedItem(ReportDetails.BP);
            catDiabetes.setSelectedItem(ReportDetails.Diabetes);
            catPcod.setSelectedItem(ReportDetails.PCOD);
            catCholestrol.setSelectedItem(ReportDetails.Cholestrol);
        }

        if (e.getSource() == sub) {
            Statement stmt = null;
            Connection myConn = null;

            int wt = Integer.parseInt(textField1.getText());
            int ht = Integer.parseInt(textField2.getText());
            String ty = (String) catThyroid.getSelectedItem();
            String bp = (String) catBP.getSelectedItem();
            String db = (String) catDiabetes.getSelectedItem();
            String pcod = (String) catPcod.getSelectedItem();
            String ch = (String) catCholestrol.getSelectedItem();
            
            try {
                myConn = MySQLConnection.getConnection();

                String mySqlQuery = "UPDATE health_report "
                        + "SET Weight = ?, Height = ?, Thyroid = ?, Diabetes = ?, Cholestrol = ?, BloodPressure = ?, PCOD = ? "
                        + "WHERE Username = '" + LoginSession.Username + "'";

                PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
                preparedStatement.setInt(1, wt);
                preparedStatement.setInt(2, ht);
                preparedStatement.setString(3, ty);
                preparedStatement.setString(4, db);
                preparedStatement.setString(5, ch);
                preparedStatement.setString(6, bp);
                preparedStatement.setString(7, pcod);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Hello, " + LoginSession.Username + " ...\nYou have updated you report Successfully!...");

                Index page = new Index();
                page.setVisible(true);
                setVisible(false);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this, "Something went wrong during insertion of report: " + exception);
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
    }

}
