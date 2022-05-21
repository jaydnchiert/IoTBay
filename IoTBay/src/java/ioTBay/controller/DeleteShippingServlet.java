package ioTBay.controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.util.logging.*;
import ioTBay.Shipping;
import ioTBay.ShippingDAO.*;

public class DeleteShippingServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        int shippingID = Integer.parseInt(request.getParameter("ShippingID"));
        ShippingManager manager = (ShippingManager) session.getAttribute("manager");
        Shipping shipping = null;
            try {
                shipping = manager.findShipment(shippingID);
                if (shipping != null) {
                manager.deleteShipment(shippingID);
                request.getRequestDispatcher("Shipping.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(EditOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
