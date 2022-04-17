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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Otp {

    int otp;

    public static boolean sendSms(String name, int otp, String mobile, JFrame frame) {
        try {
            // Construct data
            String apiKey = "apikey=" + "NjI0Yjc4NzI3MDMwMzA2NjcxNjM0NTY0NGI2ZjZmNmM=";

            String message = "&message=" + "Hey " + name + "Your OTP is " + otp;
            String sender = "&sender=" + "Dr.SFApp";
            String numbers = "&numbers="+"0"+mobile;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();
            JOptionPane.showMessageDialog(frame, "OTP has sent successfully");
            System.out.println(otp+" "+mobile);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error SMS " + e);
            return false;
        }
    }
}
