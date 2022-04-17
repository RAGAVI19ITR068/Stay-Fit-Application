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
public class ReportDetails {
    public static String Weight;
    public static String Height;
    public static String Diabetes;
    public static String Cholestrol;
    public static String BP;
    public static String Thyroid;
    public static String PCOD;
    
    public static void userReport(JFrame frame) {
        try {
            Connection myConn = MySQLConnection.getConnection();
            String mySqlQuery = "SELECT Weight, Height, Diabetes, Cholestrol, BloodPressure, Thyroid, PCOD FROM health_report "
                    + "WHERE Username = '" + LoginSession.Username + "' AND UserID = '" + LoginSession.UserID + "'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Weight = resultSet.getString("Weight");
                Height = resultSet.getString("Height");
                Diabetes = resultSet.getString("Diabetes");
                Cholestrol = resultSet.getString("Cholestrol");
                BP = resultSet.getString("BloodPressure");
                Thyroid = resultSet.getString("Thyroid");
                PCOD = resultSet.getString("PCOD");
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame, "Database error in ReportDetails: " + exception.getMessage());
        }
    }
}
