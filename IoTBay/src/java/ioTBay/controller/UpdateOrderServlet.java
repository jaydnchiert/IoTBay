package ioTBay.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            int orderID = request.getParameter("OrderID");
            int productId = request.getParameter("ProductID");
            int customerId = request.getParameter("CustomerID");
            String date = request.getParameter("Date");
            Order order = new Order(orderID,productId,customerId,date,15,50);
            OrderManager manager = (OrderManager) session.getAttribute("manager");
            try {
                    if (order != null) {
                    session.setAttribute("order",order);
                    manager.updateOrder(orderID,productId,customerId,date,15,50);
                    session.setAttribute("updated", "Update successful");
                    request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                    } else{
                    session.setAttribute("updated", "Update not successful");
                    request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                    }
                } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(EditOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("EditOrder.jsp");
        }
    }
}
