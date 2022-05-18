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
            int orderID = in.nextLine();
            System.out.print("ProductID: ");
            int productID = in.nextLine();
            System.out.print("UserID: ");
            int UserID = in.nextLine();
            System.out.print("ShippingPrice: ");
            int shippingPrice = in.nextLine();
            System.out.print("TotalPrice: ");
            int totalPrice = in.nextLine();
            System.out.print("Date");
            String date = in.nextLine();

            db.addOrder(orderID, productID, userID, shippingPrice, totalPrice, date);

            System.out.println("Order is added to database.");
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
