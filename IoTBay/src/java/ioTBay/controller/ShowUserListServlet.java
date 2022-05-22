/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ioTBay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
*/
import java.util.ArrayList;
import ioTBay.User;
import ioTBay.dao.UserManager;
/**
 *
 * @author Le
 */
public class ShowUserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       UserManager userManager = (UserManager) session.getAttribute("userManager");
       
       User user = (User) session.getAttribute("user");
       ArrayList temp = null;
       
       try {
               temp = userManager.fetchUsers();
               session.setAttribute("temp", temp);
               request.getRequestDispatcher("./AdminIndex.jsp").include(request, response);
           } 
           catch (SQLException ex) {
               Logger.getLogger(ShowUserListServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
}
