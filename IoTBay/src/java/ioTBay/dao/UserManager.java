/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ioTBay.User;

/**
 *
 * @author Jaydn
 */
/* 
* UserManager is the primary DAO class to interact with the User Table. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class UserManager {

private Statement st;
   
public UserManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public User findUser(String email, String password) throws SQLException {       
   //setup the select sql query string 
   String fetch = "select * from iotdb.IoTUser where EmailAddress = '" + email + "' and Password ='" + password + "'";
   //execute this query using the statement field
   ResultSet rs = st.executeQuery(fetch);
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters  
   while (rs.next()) {
       String userEmail = rs.getString(4);
       String userPassword = rs.getString(6);
       if (userEmail.equals(email) && userPassword.equals(password)) {
           Integer userID = rs.getInt(1);
           String userFirstName = rs.getString(2);
           String userLastName = rs.getString(3);
           String userPhoneNumber = rs.getString(5);
           Character userType = rs.getString(7).charAt(0);
           return new User(userID, userFirstName, userLastName, userEmail, userPhoneNumber, password, userType);
       }
   }
   return null;   
}

//Add a user-data into the database   
public void addUser(String firstName, String lastName, String email, String phoneNumber, String password, Character userType) throws SQLException {                   //code for add-operation       
    st.executeUpdate("INSERT INTO IoTUser (FirstName, LastName, EmailAddress, PhoneNumber, Password, Usertype) VALUES (" + firstName + ", " + lastName + ", " + email + ", " + phoneNumber + ", " + password + ", " + userType + ");");  
}

//update a user details in the database   
public void updateUser( String firstName, String lastName, String email, String phoneNumber, String password) throws SQLException {       
   //code for update-operation  
    st.executeUpdate("UPDATE iotdb SET FIRSTNAME = ' " + firstName + "', LASTNAME = ' " + lastName + " ', EMAIL= ' " + email + " ', PHONENUMBER = ' " + phoneNumber + " ', PASSWORD = ' " + password + " ' WHERE EMAIL = ' " + email + " ' ");

}       

//delete a user from the database   
public void deleteUser(String email) throws SQLException{       
   //code for delete-operation   
   st.executeUpdate("DELETE FROM iotdb WHERE EMAIL = ' " + email + " ' ");
   
}

//list all users in the database
public ArrayList<User> fetchUsers() throws SQLException {
    String fetch = "SELECT * FROM iotdb";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<User> temp = new ArrayList();
    
    while (rs.next()){
        Integer userID = rs.getInt(1);
        String userFirstName = rs.getString(2);
        String userLastName = rs.getString(3);
        String userEmail = rs.getString(4);
        String userPhoneNumber = rs.getString(5);
        String userPassword = rs.getString(6);
        Character userType = rs.getString(7).charAt(0);
        temp.add(new User(userID, userFirstName, userLastName, userEmail, userPhoneNumber, userPassword, userType));
    }
    return temp;
}

 

}
