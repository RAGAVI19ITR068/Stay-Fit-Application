/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StayFitApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ragavi
 */
public class Operation {

    public static boolean isLogin(String username, String password, JFrame frame) {
        try {
            Connection myConn = MySQLConnection.getConnection();
            String mySqlQuery = "SELECT UserID, FirstName, LastName, Age, City, Email, Mobile, Username, Password FROM users "
                    + "WHERE Username = '" + username + "' AND Password = '" + password + "'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LoginSession.UserID = resultSet.getString("UserID");
                LoginSession.Firstname = resultSet.getString("FirstName");
                LoginSession.Lastname = resultSet.getString("LastName");
                LoginSession.UserAge = resultSet.getString("Age");
                LoginSession.UserCity = resultSet.getString("City");
                LoginSession.UserEmail = resultSet.getString("Email");
                LoginSession.UserMobile = resultSet.getString("Mobile");
                LoginSession.Username = resultSet.getString("Username");
                LoginSession.UserPass = resultSet.getString("Password");

                return true;
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
            return false;
        }
        return false;
    }
}
