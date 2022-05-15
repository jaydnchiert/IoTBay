/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package ioTBay.controller;


 import java.io.IOException;
 import java.sql.Connection;
 import java.sql.SQLException;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import ioTBay.dao.*;

 /**
  *
  * @author louistsou
  */

 public class OrderServlet extends HttpServlet {
 private DBConnector db;
 private UserManager manager;
 private Connection conn;

     @Override //Create and instance of DBConnector for the deployment session
     public void init() {
         try {
             db = new DBConnector();
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     public void doGet(HttpServletRequest request, HttpServletResponse response)
 			           throws ServletException, java.io.IOException {
     response.setContentType("text/html;charset=UTF-8");
     HttpSession session = request.getSession();
     conn = db.openConnection();
     try
     {
          Order order = new Order();
          order.setOrderID(request.getParameter("OrderID"));
          order.setDate(request.getParameter("Date"));

          order = OrderDAO.findOrder(order);
          if (order.isValid())
          {

               HttpSession session = request.getSession(true);
               session.setAttribute("CurrentSessionOrder",order);
               response.sendRedirect("OrderFound.jsp"); //logged-in page
          }

          else
               response.sendRedirect("invalidOrder.jsp"); //error page
     }
 }
