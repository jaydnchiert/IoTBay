package ioTBay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import ioTBay.Shipping;
import ioTBay.ShippingDAO.*;

public class AddShippingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                HttpSession session = request.getSession();
                int shippingID = Integer.parseInt(request.getParameter("shippingID"));
                int orderID = Integer.parseInt(request.getParameter("orderID"));
                int userID = Integer.parseInt(request.getParameter("userID"));
                String status = request.getParameter("status");
                String date = request.getParameter("date");
                String address = request.getParameter("address");
                ShippingManager manager = (ShippingManager) session.getAttribute("shippingManager");

    try {
        Shipping exist = manager.findShipment(shippingID);
        if (exist != null) {
            session.setAttribute("duplicate", "Shipment already exists in the database.");
            } else {
            manager.addShipment(shippingID,orderID,userID,status,date,address);
            Shipping shipping = new Shipping(shippingID,orderID,userID,status,date,address);
            session.setAttribute("Shipping",shipping);
            request.getRequestDispatcher("Shipping.jsp").include(request, response);
            }
        } catch (SQLException ex){
        Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
