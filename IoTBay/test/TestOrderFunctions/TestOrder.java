/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
 package TestOrderFunctions;
 import ioTBay.Order;
 import ioTBay.OrderDAO.OrderManager;
 import ioTBay.dao.DBConnector;
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
    private static Scanner in = new Scanner(System.in);
    @Test
    public void TestOrder() {
      try{
              DBConnector connector = new DBConnector();
              Connection conn = connector.openConnection();
              OrderManager db = new OrderManager(conn);
              System.out.print("OrderID: ");
              Integer orderID = in.nextInt();
              System.out.print("ProductID: ");
              Integer productID = in.nextInt();
              System.out.print("UserID: ");
              Integer userID = in.nextInt();
              Integer shippingPrice = 15;
              Integer totalPrice = 50;
              System.out.print("Date: ");
              String date = in.nextLine();

              db.addOrder(orderID, productID, userID, date, shippingPrice, totalPrice);
              Order order = new Order(orderID, productID, userID, date, shippingPrice, totalPrice);
              Order testOrder = db.findOrder(orderID, date);

              assertSame(order, testOrder);
              assertEquals(order.getOrderID(),testOrder.getOrderID());
              assertEquals(order.getProductID(),testOrder.getProductID());
              assertEquals(order.getUserID(),testOrder.getUserID());
              assertEquals(order.getDate(),testOrder.getDate());
              connector.closeConnection();


          }catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(TestOrder.class.getName()).log(Level.SEVERE, null, ex);
          }
      }


}
