/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package ioTBay.Controller;

 import java.io.IOException;
 import java.sql.SQLException;
 import java.util.Hashmap;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import ioTBay.Order;
 import ioTBay.OrderDAO.OrderManager;


  /**
   *
   * @author louistsou
   */

  public class FindOrderServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             HttpSession session = request.getSession();
             int id = request.getParameter("OrderID");
             //4- capture the posted password
             String date = request.getParameter("Date");
             //5- retrieve the manager instance from session
             OrderManager manager = (OrderManager) session.getAttribute("manager");
             Order order = null;
             try {
                     order = manager.findOrder(id, date);
                 } catch (SQLException | NullPointerException ex) {
                     System.out.println(ex.getMessage() == null? "Order does not exist" : "welcome");
                     }
                 if (order != null) {
                 session.setAttribute("order",order);
                 request.getRequestDispatcher("Order.jsp").include(request, response);
                 } else{
                 session.setAttribute("existErr", "Order does not exist in Database.");
                 request.getRequestDispatcher("FindOrder.jsp").include(request, response);
                 }
         }
     }
