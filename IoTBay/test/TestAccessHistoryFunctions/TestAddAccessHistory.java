/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestAccessHistoryFunctions;

import ioTBay.dao.DBConnector;
import ioTBay.dao.AccessHistoryManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;


/**
 *
 * @author Jaydn
 */
public class TestAddAccessHistory {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            AccessHistoryManager db = new AccessHistoryManager(conn);
            
            System.out.print("UserId: ");
            Integer userId = in.nextInt();
            System.out.println("LoginTime: current_timestamp");
            
            db.addAccessHistory(userId);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddAccessHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
