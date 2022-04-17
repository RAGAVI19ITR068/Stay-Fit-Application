/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ragavi
 */
public class ValidateEmail {

    public static boolean isValid(String email) {
        if (email.matches("^[a-z0-9+_.-]+@[a-z.]+.[a-z]$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAvail(String email, JFrame frame) {
        int count = 0;

        Statement stmt = null;
        Connection myConn = null;
        try {
            myConn = MySQLConnection.getConnection();

            String mySqlQuery = "SELECT COUNT(*) FROM USERS "
                    + "WHERE Email = '"+email+"'";
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
}
