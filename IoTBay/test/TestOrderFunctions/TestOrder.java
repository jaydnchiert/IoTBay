/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestOrderFunctions;
import iotBay.OrderDAO.*;
import ioTBay.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author louistsou
 */
public class TestOrder {
    @Test
    public void TestOrder() {
      private static Scanner in = new Scanner(System.in);
      try{
              DBConnector connector = new DBConnector();
              Connection conn = connector.openConnection();
              OrderManager db = new OrderManager(conn);
              System.out.print("OrderID: ");
              int orderID = in.nextInt;
              System.out.print("ProductID: ");
              int productID = in.nextInt;
              System.out.print("UserID: ");
              int userID = in.nextInt;
              int shippingPrice = 15;
              int totalPrice = 50;
              System.out.print("Date: ");
              String date = in.nextLine;

              db.addOrder(orderID, productID, userID, date, shippingPrice, totalPrice);
              Order order = new Order(orderID, productID, userID, date, shippingPrice, totalPrice);
              Order testOrder = db.findOrder(orderID, date);

              assertSame(order, testOrder);
              assertEquals(order.OrderID,testOrder.OrderID);
              assertEquals(order.ProductID,testOrder.ProductID);
              assertEquals(order.UserID,testOrder.UserID);
              assertEquals(order.Date,testOrder.Date);
              connector.closeConnection();


          }catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(TestFindOrder.class.getName()).log(Level.SEVERE, null, ex);
          }
      }


}
