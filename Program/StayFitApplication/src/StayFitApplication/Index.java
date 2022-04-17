/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

/**
 *
 * @author Ragavi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

class Index extends JFrame implements MouseListener {

    JLabel wel, name, email, mob, logout, edit, allUsers, allReports, uploadReport, editReport, dietFood, exercise;
    JButton create, view, get, cancel, payment, users;
    JComboBox cList;
    JPanel profpan, contentpan;

    Index() {

        ImageIcon icon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\main-bg.jpg");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1920, 1030);
        background.setLayout(null);
        add(background);

        Font f = new Font("Bradley Hand ITC", Font.BOLD, 70);
        JLabel head = new JLabel("STAY FIT APPLICATION");
        head.setBounds(510, 10, 1000, 100);
        head.setFont(f);
        head.setForeground(new Color(36, 31, 30));
        background.add(head);

        profpan = new JPanel();

        Font f1 = new Font("Bradley Hand ITC", Font.BOLD, 30);
        Font f2 = new Font("Lucida Calligraphy", Font.BOLD, 40);
        Font f3 = new Font("Lucida Calligraphy", Font.PLAIN, 18);

        wel = new JLabel("Hello, " + LoginSession.Username + " ...");
        wel.setBounds(50, 350, 300, 40);
        wel.setBackground(new Color(36, 31, 30));
        wel.setForeground(new Color(255, 255, 255));
        wel.setFont(f1);
        profpan.add(wel);

        ImageIcon editIcon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\edit_pen.png");
        edit = new JLabel(editIcon);
        edit.setBounds(330, 320, 80, 80);
        edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profpan.add(edit);
        edit.addMouseListener(this);

        name = new JLabel("Name    :  " + LoginSession.Firstname + " " + LoginSession.Lastname);
        name.setBounds(350, 110, 600, 40);
        name.setBackground(new Color(36, 31, 30));
        name.setForeground(new Color(255, 255, 255));
        name.setFont(f1);
        profpan.add(name);

        email = new JLabel("Email   :  " + LoginSession.UserEmail);
        email.setBounds(350, 170, 650, 40);
        email.setBackground(new Color(36, 31, 30));
        email.setForeground(new Color(255, 255, 255));
        email.setFont(f1);
        profpan.add(email);

        mob = new JLabel("Mobile   :  " + LoginSession.UserMobile);
        mob.setBounds(350, 230, 500, 40);
        mob.setBackground(new Color(36, 31, 30));
        mob.setForeground(new Color(255, 255, 255));
        mob.setFont(f1);
        profpan.add(mob);

        profpan.setBounds(240, 100, 1400, 430);
        profpan.setBackground(new Color(36, 31, 30));
        profpan.setLayout(null);
        background.add(profpan);

        contentpan = new JPanel();

        if ("U - 8243".equals(LoginSession.UserID)) {
            ImageIcon profIcon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\user.png");
            JLabel profile = new JLabel(profIcon);
            profile.setBounds(100, 50, 200, 270);
            profpan.add(profile);

            ImageIcon logoutIcon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\logout.png");
            logout = new JLabel(logoutIcon);
            logout.setBounds(1100, 100, 200, 270);
            logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            profpan.add(logout);
            logout.addMouseListener(this);

            ImageIcon usersIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\users.png");
            allUsers = new JLabel(usersIcon);
            allUsers.setBounds(200, 50, 400, 270);
            contentpan.add(allUsers);
            allUsers.addMouseListener(this);

            ImageIcon reportIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\viewReport.png");
            allReports = new JLabel(reportIcon);
            allReports.setBounds(800, 50, 400, 270);
            contentpan.add(allReports);
            allReports.addMouseListener(this);

        } else {
            ImageIcon profIcon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\user.png");
            JLabel profile = new JLabel(profIcon);
            profile.setBounds(100, 50, 200, 270);
            profpan.add(profile);

            ImageIcon logoutIcon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\logout.png");
            logout = new JLabel(logoutIcon);
            logout.setBounds(1100, 100, 200, 200);
            logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            profpan.add(logout);
            logout.addMouseListener(this);

            if (ReportsAvailable.isReportAvail(this)) {
                ImageIcon editReportIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\editReport.png");
                editReport = new JLabel(editReportIcon);
                editReport.setBounds(60, 100, 400, 200);
                editReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                contentpan.add(editReport);
                editReport.addMouseListener(this);
                
                ImageIcon dietIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\healthyFood.png");
                dietFood = new JLabel(dietIcon);
                dietFood.setBounds(500, 100, 400, 200);
                dietFood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                contentpan.add(dietFood);
                dietFood.addMouseListener(this);
                
                ImageIcon exerciseIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\exercises.png");
                exercise = new JLabel(exerciseIcon);
                exercise.setBounds(940, 100, 400, 200);
                exercise.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                contentpan.add(exercise);
                exercise.addMouseListener(this);
            } else {
                ImageIcon reportIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\uploads.png");
                uploadReport = new JLabel(reportIcon);
                uploadReport.setBounds(500, 100, 400, 200);
                uploadReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                contentpan.add(uploadReport);
                uploadReport.addMouseListener(this);
            }

        }

        contentpan.setBounds(240, 530, 1400, 400);
        contentpan.setBackground(new Color(170, 160, 150));
        contentpan.setLayout(null);
        background.add(contentpan);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STAY FIT APPLICATION");
        setSize(1920, 1030);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == edit) {
            EditProfile ep = new EditProfile();
            ep.setVisible(true);
            setVisible(false);
        }
        if (e.getSource() == allUsers) {
            int count = UserAvailable.countUser(this);
            if (count != 0) {
                UserAvailable.allUsers(this, count);
            } else {
                JOptionPane.showMessageDialog(this, "No Users Available");
            }
        }
        if (e.getSource() == allReports) {
            int count = ReportsAvailable.countReport(this);
            if (count != 0) {
                ReportsAvailable.allReports(this, count);
            } else {
                JOptionPane.showMessageDialog(this, "No Users Report Available");
            }
        }
        if(e.getSource() == uploadReport){
            UploadReport uploadReport1 = new UploadReport();
            uploadReport1.setVisible(true);
            setVisible(false);
        }
        if(e.getSource() == editReport){
            ReportDetails.userReport(this);
            EditReport editReport1 = new EditReport();
            editReport1.setVisible(true);
            setVisible(false);
        }
        if(e.getSource()== dietFood){
            DietFood dietFood1 = new DietFood();
            dietFood1.setVisible(true);
            setVisible(false);
        }
        if(e.getSource() == exercise){
            Exercise exercise1 = new Exercise();
            exercise1.setVisible(true);
            setVisible(false);
        }
        if (e.getSource() == logout) {
            setVisible(false);
            Logout.logout();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
