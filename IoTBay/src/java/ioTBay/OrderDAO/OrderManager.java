package ioTBay.OrderDAO;

import ioTBay.Order;
import java.sql.*;
import java.util.ArrayList;

/*
* DBManager is the primary DAO class to interact with the database.
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class OrderManager {

private Statement st;

public OrderManager(Connection conn) throws SQLException {
   st = conn.createStatement();
}


public Order findOrder(int OrderID) throws SQLException {
   String fetch = "select * from CUSTOMERORDER where OrderID = '" + OrderID + "'";
   ResultSet rs = st.executeQuery(fetch);

   while(rs.next()){
      int orderID = rs.getInt(1);
      if (orderID==OrderID){
         int userID = rs.getInt(3);
         int productID = rs.getInt(2);
         int shippingPrice = rs.getInt(4);
         int totalPrice = rs.getInt(5);
         String date  = rs.getString(6);
         return new Order(orderID, productID, userID, date, shippingPrice, totalPrice);
    }
}
   return null;
}

//Add a user-data into the database
public void addOrder(int OrderID, int ProductID, int UserID, String Date, int ShippingPrice, int TotalPrice) throws SQLException {                   //code for add-operation
  st.executeUpdate("INSERT INTO CUSTOMERORDER " + "VALUES ('" + OrderID + "', '" + ProductID + "', '"+UserID + "','"+ "','" + ShippingPrice + "', '" + TotalPrice + "', '" + Date + "')");

}

//update a user details in the database
public void updateOrder(int OrderID, int ProductID, int UserID, String Date, int ShippingPrice, int TotalPrice) throws SQLException {
   st.executeUpdate("UPDATE CUSTOMERORDER " + "VALUES ('" + OrderID + "', '" + ProductID + "', '"+UserID + "','"+ "','" + ShippingPrice + "', '" + TotalPrice + "', '" + Date + "')");

}

//delete a user from the database
public void deleteOrder(int OrderID) throws SQLException{
   st.executeUpdate("DELETE FROM CUSTOMERORDER WEHRE OrderID='" + OrderID + "'");

}

public ArrayList<Order> fecthOrders() throws SQLException {
   String fetch  ="select * from STUDENTS";
   ResultSet rs = st.executeQuery(fetch);
   ArrayList<Order> temp = new ArrayList();

   while (rs.next()){
      int orderID = rs.getInt(1);
      int userID = rs.getInt(2);
      int productID = rs.getInt(3);
      String date = rs.getString(4);
      int shippingPrice = rs.getInt(5);
      int totalPrice = rs.getInt(6);
      temp.add(new Order(orderID,userID,productID,date,shippingPrice,totalPrice));
}
return temp;
}



}
