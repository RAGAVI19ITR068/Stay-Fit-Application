/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ragavi
 */
public class UserAvailable {

    public static boolean isAvail(String username, JFrame frame) {
        int count = 0;

        Statement stmt = null;
        Connection myConn = null;
        try {
            myConn = MySQLConnection.getConnection();

            String mySqlQuery = "SELECT COUNT(*) FROM USERS "
                    + "WHERE Username = '"+username+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            count = resultSet.getInt(1);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Something went wrong : " + exception);
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
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void allUsers(JFrame frame, int count) {
        Object[] colHeads = {"UID", "Username", "FirstName", "LastName", "Email", "Mobile", "Age", "City"};
        Object[][] data = new Object[count][9];
        try{
            Connection myConn = MySQLConnection.getConnection();
            String mySqlQuery = "SELECT UserID, FirstName, LastName, Email, Mobile, Age, City, Username FROM users";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            int i=0;
            while(resultSet.next()){
                int j=0;
                data[i][j] = resultSet.getString("UserID");
                j++;
                data[i][j] = resultSet.getString("Username");
                j++;
                data[i][j] = resultSet.getString("FirstName");
                j++;
                data[i][j] = resultSet.getString("LastName");
                j++;
                data[i][j] = resultSet.getString("Email");
                j++;
                data[i][j] = resultSet.getString("Mobile");
                j++;
                data[i][j] = resultSet.getString("Age");
                j++;
                data[i][j] = resultSet.getString("City");
                i++;
            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(frame, "Available users : "+exception.getMessage());
        }
        JTable table = new JTable(data, colHeads);
        table.setBounds(10, 10, 1000, 300);
        table.setBackground(new Color(187, 222, 251));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 10, 1000, 100);
        scroll.setBackground(new Color(187, 222, 251));

        JOptionPane.showMessageDialog(frame, scroll);
    }
    
    public static int countUser(JFrame frame) {
        int count = 0;

        Statement stmt = null;
        Connection myConn = null;
        try {
            myConn = MySQLConnection.getConnection();

            String mySqlQuery = "SELECT COUNT(*) FROM users";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            count = resultSet.getInt(1);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Something went wrong : " + exception);
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
        return count;
    }
}
