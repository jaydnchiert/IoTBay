package ioTBay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ioTBay.Order;
import ioTBay.OrderDAO.OrderManager;
import java.util.logging.Logger;


 /**
  *
  * @author louistsou
  */

 public class UpdateOrderServlet extends HttpServlet {
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            Integer orderID = Integer.parseInt(request.getParameter("OrderID"));
            Integer productID = Integer.parseInt(request.getParameter("ProductID"));
            Integer userID = Integer.parseInt(request.getParameter("UserID"));
            String date = request.getParameter("Date");
            Order order = new Order(orderID,productID,userID,date,15,50);
            OrderManager manager = (OrderManager) session.getAttribute("orderManager");
            try {
                    if (order != null) {
                    session.setAttribute("order",order);
                    manager.updateOrder(orderID,productID,userID,date,15,50);
                    session.setAttribute("updated", "Update successful");
                    request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                    } else{
                    session.setAttribute("updated", "Update not successful");
                    request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                    }
                } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(UpdateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("EditOrder.jsp");

    }
}
