package ioTBay.controller;

import java.io.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import ioTBay.Shipping;
import ioTBay.ShippingDAO.*;

public class SearchShippingServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             HttpSession session = request.getSession();
             int id = Integer.parseInt(request.getParameter("shippingID"));
             //- retrieve the manager instance from session
             ShippingManager manager = (ShippingManager) session.getAttribute("manager");
             Shipping shipping = null;
             try {
                     shipping = manager.findShipment(id);
                 } catch (SQLException | NullPointerException ex) {
                     System.out.println(ex.getMessage() == null? "Shipment does not exist": "welcome");
                     }
                 if (shipping != null) {
                 session.setAttribute("shipping",shipping);
                 request.getRequestDispatcher("Shipping.jsp").include(request, response);
                 }
                 else {
        session.setAttribute("existErr", "Shipment not found. Double check your shipment ID.");
        request.getRequestDispatcher("SearchShip.jsp").include(request, response);
        }
    }
}

