/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package ioTBay.controller;


 import java.io.IOException;
 import java.sql.SQLException;
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

           //1- retrieve the current session
           HttpSession session = request.getSession();

           int id = request.getParameter("OrderID");
           //4- capture the posted password
           String date = request.getParameter("Date");
           //5- retrieve the manager instance from session
           OrderManager manager = (OrderManager) session.getAttribute("manager");
           Order order = null;


           try {
                   order = manager.findOrder(id, date);
                   if (order != null) {
                     HttpSession session = request.getSession(true);
                     session.setAttribute("CurrentSessionOrder",order);
                     response.sendRedirect("OrderFound.jsp"); //logged-in page
                   }
               } catch (SQLException | NullPointerException ex) {
                   session.setAttribute("ErrorOrder");
                   response.sendRedirect("invalidOrder.jsp"); //error page
               }
           }
       }
