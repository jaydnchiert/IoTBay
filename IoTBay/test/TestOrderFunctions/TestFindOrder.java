package TestOrderFunctions;

import ioTBay.Order;
import ioTBay.OrderDAOdao.DBConnector;
import ioTBay.OrderDAOdao.OrderManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class TestFindOrder {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        try{
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            OrderManager db = new OrderManager(conn);

            System.out.print("OrderID: ");
            int orderID = "1";
            System.out.println(orderID);
            System.out.print("Date: ");
            String date = "01/05/2000";
            System.out.println(date);

            Order order = db.findOrder(orderID, date);

            System.out.println(order);
            connector.closeConnection();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
