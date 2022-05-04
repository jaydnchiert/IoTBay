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

//Find user by email and password in the database   
public Order findOrder(int OrderID, int ProductID, int CustomerID, String Date, int ShippingPrice, int TotalPrice) throws SQLException {       
   String fetch = "select * from STAFF.Order where OrderID = '" + OrderID + "' and ProductID='" + ProductID +"' and CustomerID='" + CustomerID+"'";
   ResultSet rs = st.executeQuery(fetch);
              
   while(rs.next()){
      int orderID = rs.getInt(1);
      String date  = rs.getString(4);
      if (orderID==OrderID&&date==Date){
         int customerID = rs.getInt(2);
         int productID = rs.getInt(3);
         int shippingPrice = rs.getInt(5);
         int totalPrice = rs.getInt(6);
         return new Order(orderID, productID, customerID, date, shippingPrice, totalPrice);
    }
}
   return null;   
}

//Add a user-data into the database   
public void addOrder(int OrderID, int ProductID, int CustomerID, String Date, int ShippingPrice, int TotalPrice) throws SQLException {                   //code for add-operation       
  st.executeUpdate("INSERT INTO STAFF.CUSTOMERORDER " + "VALUES ('" + OrderID + "', '" + ProductID + "', '"+CustomerID + "','"+ "', '"+Date + "','" + ShippingPrice + "', '" + TotalPrice +"')");   

}

//update a user details in the database   
public void updateOrder(int OrderID, int ProductID, int CustomerID, String Date, int ShippingPrice, int TotalPrice) throws SQLException {       
   st.executeUpdate("UPDATE STAFF.CUSTOMERORDER " + "VALUES ('" + OrderID + "', '" + ProductID + "', '"+CustomerID + "','"+ "', '"+ Date + "','" + ShippingPrice + "', '" + TotalPrice +"')");

}       

//delete a user from the database   
public void deleteOrder(int OrderID) throws SQLException{       
   st.executeUpdate("DELETE FROM STAFF>CUSTOMERORDER WEHRE OrderID='" + OrderID + "'");

}

public ArrayList<Order> fectOrders() throws SQLException {
   String fetch  ="select * from STUDENTS";
   ResultSet rs = st.executeQuery(fetch);
   ArrayList<Order> temp = new ArrayList();
   
   while (rs.next()){
      int orderID = rs.getInt(1);
      int customerID = rs.getInt(2);
      int productID = rs.getInt(3);
      String date = rs.getString(4);
      int shippingPrice = rs.getInt(5);
      int totalPrice = rs.getInt(6);
      temp.add(new Order(orderID,customerID,productID,date,shippingPrice,totalPrice));
}
return temp;
}

 

}