/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package ioTBay.controller;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.SQLException;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import ioTBay.Order;
 import ioTBay.OrderDAO.*;

 /**
  *
  * @author louistsou
  */
 public class EditOrderServlet extends HttpServlet{
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession();
         int id = Integer.parseInt(request.getParameter("OrderID"));
         String date = request.getParameter("Date");
         OrderManager manager = (OrderManager) session.getAttribute("manager");
         Order order = null;
             try {
                     order = manager.findOrder(id, date);
                     if (order != null) {
                     session.setAttribute("order",order);
                     request.getRequestDispatcher("EditOrder.jsp").include(request, response);
                     }
                 } catch (SQLException | NullPointerException ex) {
                 Logger.getLogger(EditOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
             request.getRequestDispatcher("EditOrder.jsp").include(request, response);
         }
     }
