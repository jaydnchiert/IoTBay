/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestUserFunctions;

import ioTBay.dao.DBConnector;
import ioTBay.dao.UserManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaydn
 */
public class TestFindEmail {
    
    public static void main(String[] args) {
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            UserManager db = new UserManager(conn);
            
            System.out.print("User email: ");
            String email = "first@gmail.com";
            System.out.println(email);
            
            Boolean found = db.findEmail(email);
            
            System.out.println(found);
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
