/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestAccessHistoryFunctions;

import ioTBay.AccessHistory;
import ioTBay.dao.AccessHistoryManager;
import ioTBay.dao.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Jaydn
 */
public class TestFindAllAccessHistory {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            AccessHistoryManager db = new AccessHistoryManager(conn);
            
            System.out.print("User: ");
            Integer userId = in.nextInt();
            
            ArrayList accessLogs = db.findAllAccessHistory(userId);
            System.out.println(accessLogs);
            
            
            
            for(int i = 0; i < accessLogs.size(); i++) {
                AccessHistory accessHistory = (AccessHistory) accessLogs.get(i);
                System.out.println(accessHistory.getLoginTime());
            }
            
            
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddAccessHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
