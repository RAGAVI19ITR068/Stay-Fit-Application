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
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ragavi
 */
public class ValidateMobile {
    public static String mobile;
    public static boolean isValid(String mobNumber) {
        if (mobNumber.matches("\\d{10}")) {
            if (mobNumber.matches("^[6-9][0-9]{9}$")) {
                mobile = mobNumber;
                return true;
            } else {
                return false;
            }
        } else if (mobNumber.matches("^[0][6-9][0-9]{9}$")) {
            mobile = mobNumber.substring(1, mobNumber.length());
            return true;
        } else if (mobNumber.matches("\\+\\d[91][-\\s]\\d{10}")) {
            if (Pattern.matches("^[6-9][0-9]{9}$", mobNumber.substring(4, mobNumber.length()))) {
                mobile = mobNumber.substring(4, mobNumber.length());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isAvail(String mobile, JFrame frame) {
        int count = 0;

        Statement stmt = null;
        Connection myConn = null;
        try {
            myConn = MySQLConnection.getConnection();

            String mySqlQuery = "SELECT COUNT(*) FROM USERS "
                    + "WHERE Mobile = '"+mobile+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            count = resultSet.getInt(1);
            System.out.println(count);
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
        System.out.println(count);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
