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
public class Logout {
    public static void logout(){
        LoginSession.isLoggedIn = false;
        Login loginScreen = new Login();
        loginScreen.setVisible(true);
    }
}
