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
 import jakarta.servlet.ServletException;
 import jakarta.servlet.http.HttpServlet;
 import jakarta.servlet.http.HttpServletRequest;
 import jakarta.servlet.http.HttpServletResponse;
 import jakarta.servlet.http.HttpSession;
 import ioTBay.OrderDAO.*;


  /**
   *
   * @author louistsou
   */

  public class OrderServlet extends HttpServlet {
  private DBConnector db;
  private OrderManager manager;
  private Connection conn;
     @Override
     public void init() {
          try {
              db = new DBConnector();
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, java.io.IOException {
     response.setContentType("text/html;charset=UTF-8");
     HttpSession session = request.getSession();
     conn = db.openConnection();
     try
     {
        manager = new OrderManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //export the DB manager to the view-session (JSPs)
        session.setAttribute("orderManager", manager);
     }
     @Override
     public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  }
