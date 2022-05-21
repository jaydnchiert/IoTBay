package ioTBay.controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import ioTBay.Shipping;
import ioTBay.ShippingDAO.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditShippingServlet extends HttpServlet {
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
            Shipping shipping = null;
            try {
                Shipping exist = manager.findShipment(ShipmentID);
                if (shipping !=null) {
                    session.setAttribute("shipping",shipping);
                    request.getRequestDispatcher("Shipping.jsp").include(request, response);
                }
                if (Status == "Shipped") {
                    session.setAttribute("shipped", "Order has already been shipped and cannot be changed.");
                } else {
                    session.setAttribute("shipping",shipping);
                    request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                  }
                } catch (SQLException | NullPointerException ex) {
                 Logger.getLogger(EditOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
}
