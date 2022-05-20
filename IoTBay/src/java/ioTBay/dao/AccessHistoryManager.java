/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.dao;

import ioTBay.AccessHistory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Jaydn
 */
public class AccessHistoryManager {
    
    private Statement st;
   
    public AccessHistoryManager(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }
    
  //Find Access History Logs   
    public ArrayList<AccessHistory> findAccessHistory(Integer userId) throws SQLException {       
       //setup the select sql query string

       String fetch = "select * from AccessHistory where userId = " + userId;
       //execute this query using the statement field
       ResultSet rs = st.executeQuery(fetch);
       
       ArrayList<AccessHistory> accessLogs = new ArrayList();
       
       //search the ResultSet for a user using the parameters  
       while (rs.next()) {
           Integer accessId = rs.getInt(1);
           Integer accessUserId = rs.getInt(2);
           Timestamp loginTime = rs.getTimestamp(3);
           Timestamp logoutTime = rs.getTimestamp(4);
           accessLogs.add(new AccessHistory(accessId, accessUserId, loginTime, logoutTime));
       }
       return accessLogs;
    }

    //Add a user-data into the database   
    public void addAccessHistory(Integer userId) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO AccessHistory (UserID, LoginTime) VALUES (" + userId + ", current_timestamp)");
    }
    
    public void addLogoutHistory(Integer accessId) throws SQLException {
        st.executeUpdate("UPDATE AccessHistory SET LogoutTime = current_timestamp WHERE AccessId = " + accessId);
    }
}
