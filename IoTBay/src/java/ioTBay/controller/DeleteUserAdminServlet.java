/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ioTBay.User;
import ioTBay.dao.UserManager;
import jakarta.servlet.http.HttpSession;


public class DeleteUserAdminServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        UserManager manager = (UserManager) session.getAttribute("userManager");
        User user = (User) session.getAttribute("user");
        
        try {
            
            manager.deleteUser(user.getUserID());
            
        }catch(SQLException ex) {
            Logger.getLogger(DeleteUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.invalidate();
        request.getRequestDispatcher("AdminIndex.jsp").include(request, response);
  
    }
}
