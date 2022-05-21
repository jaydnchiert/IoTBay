package ioTBay.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import ioTBay.Shipping;
import ioTBay.ShippingDAO.*;

/**
 *
 * @author fernr
 */

public class AddShippingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
                HttpSession session = request.getSession();
                int ShipmentID = Integer.parseInt(request.getParameter("ShipmentID"));
                int OrderID = Integer.parseInt(request.getParameter("OrderID"));
                int UserID = Integer.parseInt(request.getParameter("UserID"));
                String Status = request.getParameter("Status");
                String Date = request.getParameter("Date");
                String Address = request.getParameter("Address");
                ShippingManager manager = (ShippingManager) session.getAttribute("manager");            
    try {
        Shipping exist = manager.findShipment(ShipmentID);
        if (exist != null) {
            session.setAttribute("duplicate", "Shipment already exists in the database.");
            } else {
            manager.addShipment(ShipmentID,OrderID,UserID,Status,Date,Address);
            Shipping shipping = new Shipping(ShipmentID,OrderID,UserID,Status,Date,Address);
            session.setAttribute("Shipping",shipping);
            request.getRequestDispatcher("Shipping.jsp").include(request, response);
            }
        } catch (SQLException ex){
        Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
