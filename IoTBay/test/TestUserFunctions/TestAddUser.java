package TestUserFunctions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import ioTBay.dao.DBConnector;
import ioTBay.dao.UserManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;


/**
 *
 * @author Jaydn
 */
public class TestAddUser {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            UserManager db = new UserManager(conn);
            
            System.out.print("User email: ");
            String email = in.nextLine();
            System.out.print("First Name: ");
            String firstName = in.nextLine();
            System.out.print("Last Name: ");
            String lastName = in.nextLine();
            System.out.print("Password: ");
            String password = in.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = in.nextLine();
            
            db.addUser(firstName, lastName, email, phoneNumber, password, 'c');
            
            System.out.println("User is added to database.");
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
