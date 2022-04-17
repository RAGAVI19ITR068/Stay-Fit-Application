/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ragavi
 */
public class Exercise extends JFrame implements MouseListener {

    JLabel title, fd1, fd2, prev, next, back;
    JButton create, view, get, cancel, payment, users;
    JComboBox cList;
    JPanel foodpan;

    Exercise() {

        ImageIcon icon = new ImageIcon("D:\\5th Sem\\SE\\E-Learning\\image\\indexbg.jpg");
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1920, 1030);
        background.setLayout(null);
        add(background);

        Font f = new Font("Bradley Hand ITC", Font.BOLD, 75);
        JLabel head = new JLabel("STAY FIT APPLICATION");
        head.setBounds(510, 10, 1000, 100);
        head.setFont(f);
        head.setForeground(new Color(36, 31, 30));
        background.add(head);

        foodpan = new JPanel();

        ImageIcon backIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\back-arrow2.png");
        back = new JLabel(backIcon);
        back.setBounds(50, 20, 60, 60);
        back.setBackground(new Color(36, 31, 30));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        foodpan.add(back);
        back.addMouseListener(this);

        Font f1 = new Font("Lucida Calligraphy", Font.BOLD, 40);
        title = new JLabel("EXERCISES");
        title.setFont(f1);
        title.setBounds(400, 30, 400, 50);
        title.setForeground(new Color(255,255,255));
        foodpan.add(title);

        ImageIcon iconPrev = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\left-arrow2.png");
        prev = new JLabel(iconPrev);
        prev.setBounds(100, 280, 60, 60);
        prev.setLayout(null);
        prev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        foodpan.add(prev);
        prev.addMouseListener(this);

        ImageIcon iconFood1 = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\exercise_2.gif");
        fd1 = new JLabel(iconFood1);
        fd1.setBounds(400, 80, 300, 500);
        fd1.setLayout(null);
        fd1.setVisible(true);
        foodpan.add(fd1);

        ImageIcon iconFood2 = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\exercise_3.gif");
        fd2 = new JLabel(iconFood2);
        fd2.setBounds(400, 80, 300, 500);
        fd2.setLayout(null);
        fd2.setVisible(false);
        foodpan.add(fd2);

        ImageIcon iconNext = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\NetBeansProjects\\StayFitApplication\\src\\images\\right-arrow2.png");
        next = new JLabel(iconNext);
        next.setBounds(900, 280, 60, 60);
        next.setLayout(null);
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        foodpan.add(next);
        next.addMouseListener(this);

        foodpan.setBounds(410, 220, 1100, 650);
        foodpan.setBackground(new Color(36, 31, 30));
        foodpan.setLayout(null);
        background.add(foodpan);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exercises");
        setSize(1920, 1030);
        setLayout(null);
        setVisible(true);
    }

    int i = 1, j = 1;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == prev) {
            if (i == 1) {
                fd1.setVisible(false);
                fd2.setVisible(true);
                i++;
            } else {
                fd2.setVisible(false);
                fd1.setVisible(true);
                i--;
            }
        }
        if (e.getSource() == next) {
            if (j == 1) {
                fd1.setVisible(false);
                fd2.setVisible(true);
                j++;
            } else {
                fd2.setVisible(false);
                fd1.setVisible(true);
                j--;
            }
        }
        if (e.getSource() == back) {
            Index page = new Index();
            setVisible(false);
            page.setVisible(true);
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
