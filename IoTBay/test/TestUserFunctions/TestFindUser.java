/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestUserFunctions;

import ioTBay.User;
import ioTBay.dao.DBConnector;
import ioTBay.dao.UserManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Jaydn
 */
public class TestFindUser {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            UserManager db = new UserManager(conn);
            
            System.out.print("User email: ");
            String email = "first.last@gmail.com";
            System.out.println(email);
            System.out.print("Password: ");
            String password = "first123";
            System.out.println(password);
            
            User user = db.findUser(email, password);
            
            System.out.println(user);
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
