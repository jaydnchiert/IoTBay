package TestOrderFunctions;

import ioTBay.OrderDAO.DBConnector;
import ioTBay.OrderDAO.OrderManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class TestAddOrder {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            OrderManager db = new OrderManager(conn);

            System.out.print("OrderID: ");
            int orderID = in.nextInt();
            System.out.print("ProductID: ");
            int productID = in.nextInt();
            System.out.print("UserID: ");
            int userID = in.nextInt();
            System.out.print("ShippingPrice: ");
            int shippingPrice = in.nextInt();
            System.out.print("TotalPrice: ");
            int totalPrice = in.nextInt();
            System.out.print("Date");
            String date = in.nextLine();

            db.addOrder(orderID, productID, userID, date, shippingPrice, totalPrice);

            System.out.println("Order is added to database.");
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
