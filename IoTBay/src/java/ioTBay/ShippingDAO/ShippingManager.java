package ioTBay.ShippingDAO;

import ioTBay.Shipping;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class ShippingManager {

private Statement st;
   
public ShippingManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find shipment by ID in the database   
public Shipping findShipment(int shippingID) throws SQLException {       
   String fetch = "SELECT * FROM SHIPPING WHERE ShippingID = '" + shippingID + "";
   ResultSet rs = st.executeQuery(fetch);
   while (rs.next()) {
       int ShipmentID = rs.getInt(1);
       if (ShipmentID == (shippingID)) {
           int OrderID = rs.getInt(2);
           int ProductID = rs.getInt(3);
           String Status = rs.getString(4);
           String date = rs.getString(5);
           String Address = rs.getString(6);
           return new Shipping(shippingID, OrderID, ProductID, Status, date, Address);
       }
   }
       return null;   
}

//Add shipment into the database   
public void addShipment(int shippingID, int userID, int productID, String status, String date, String address) throws SQLException {     
  st.executeUpdate("INSERT INTO SHIPPING (shippingID, userID, productID, status) VALUES ('" + shippingID + "', '" + userID + "', '" + productID + "', '" + status + "','" + date + "', '" + address + "'");   

}

//update shipment details in the database   
public void updateShipment(int shippingID, int userID, int productID, String status, String date, String address) throws SQLException {       
   st.executeUpdate("UPDATE SHIPPING SET shippingID = ' " + shippingID + " ', userID = ' " + userID + " ', productID = ' " + productID + " ', status = ' " + status + " ', date = ' " + date + " ', address = ' " + address + " ' WHERE SHIPPINGID = ' " + shippingID + " ' ");   
}       

//delete a shipment from the database   
public void deleteShipment(int shippingID) throws SQLException{       
   st.executeUpdate("DELETE FROM SHIPPING WHERE SHIPPINGID  = ' " + shippingID + " ' ");
}

//find all existing shipments
public ArrayList<Shipping> fetchShipments() throws SQLException {
   String fetch  = "select * from SHIPPING";
   ResultSet rs = st.executeQuery(fetch);
   ArrayList<Shipping> temp = new ArrayList();

   while (rs.next()){
      int shippingID = rs.getInt(1);
      int userID = rs.getInt(2);
      int productID = rs.getInt(3);
      String status = rs.getString(4);
      String date = rs.getString(5);
      String address = rs.getString(6);
      
      temp.add(new Shipping(shippingID,userID,productID,status,date,address));
    }
return temp;
}

 
}