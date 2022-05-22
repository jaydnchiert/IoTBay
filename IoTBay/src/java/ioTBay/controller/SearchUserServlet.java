/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

/**
 *
 * @author Le
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ioTBay.User;
import ioTBay.dao.UserManager;
import java.util.ArrayList;

public class SearchUserServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //Capture posted date
        String pn = request.getParameter("phonenumber");
        UserValidator validator = new UserValidator();
        //5- retrieve the userManager instance from session    
        UserManager userManager = (UserManager) session.getAttribute("userManager");
        
        
        User user = (User) session.getAttribute("user");
        ArrayList temp = null;
        
        if (!validator.validatePhoneNumber(pn)) {
            validator.clear(session);
            session.setAttribute("temp", temp);
            session.setAttribute("phoneErr", "Error: Invalid phone number");
            request.getRequestDispatcher("AdminIndex.jsp").include(request, response);
        }
        
        try {
            temp = userManager.searchUserPhone(user.getPhoneNumber());
            if(temp.isEmpty()) {
                temp = null;
                validator.clear(session);
                session.setAttribute("temp", temp);
                session.setAttribute("logErr", "Error: No logs from this date found");
                request.getRequestDispatcher("AdminIdex.jsp").include(request, response);
            } else {
                validator.clear(session);
                session.setAttribute("temp", temp);
                request.getRequestDispatcher("AdminIndex.jsp").include(request, response);
            }
            
                
        }catch (SQLException ex) {
            
            Logger.getLogger(ShowUserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
