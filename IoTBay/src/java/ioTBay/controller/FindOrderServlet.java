/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package ioTBay.controller;

 import java.io.IOException;
 import java.sql.SQLException;
 import jakarta.servlet.ServletException;
 import jakarta.servlet.http.HttpServlet;
 import jakarta.servlet.http.HttpServletRequest;
 import jakarta.servlet.http.HttpServletResponse;
 import jakarta.servlet.http.HttpSession;
 import ioTBay.Order;
 import ioTBay.OrderDAO.OrderManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


  /**
   *
   * @author louistsou
   */

   public class FindOrderServlet extends HttpServlet {
         @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              HttpSession session = request.getSession();
              Integer id = Integer.parseInt(request.getParameter("OrderID"));
              OrderManager orderManager = (OrderManager) session.getAttribute("orderManager");
              Order order = null;
              ArrayList temp = null;
              try {
                      order = orderManager.findOrder(id);

                  } catch (SQLException ex) {
                      Logger.getLogger(FindOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                      }
              if (order != null) {
              try {
                    temp = orderManager.fecthOrders();
                    session.setAttribute("temp",temp);
                    request.getRequestDispatcher("Order.jsp").include(request, response);
            }catch(SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
              else{
              session.setAttribute("existErr", "Order does not exist");
              request.getRequestDispatcher("FindOrder.jsp").include(request,response);
              }
         }
   }
