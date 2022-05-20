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
import ioTBay.dao.UserManager;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Jaydn
 */
public class UpdateUserServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        UserValidator validator = new UserValidator();
        //3- capture the posted details      
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        //5- retrieve the manager instance from session    
        UserManager manager = (UserManager) session.getAttribute("userManager");
        
        Boolean found = false;
        
        try {
            //6- find user by email and password
            found = manager.findEmail(email);
                
        }catch (SQLException ex) {
            
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if (validator.checkEmptyRegister(firstName, lastName, email, phoneNumber, password)) {
            session.setAttribute("emptyErr", "Error: Please fill in all fields.");
            request.getRequestDispatcher("account.jsp").include(request, response);
            
        } else if (!validator.validateEmail(email)) {           
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp     
            request.getRequestDispatcher("account.jsp").include(request, response);
        //10- validate password
        } else if (!validator.validatePassword(password)) {                  
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp          
            request.getRequestDispatcher("account.jsp").include(request, response);
        
        } else if (!validator.validateName(firstName)) {
            session.setAttribute("firstNameErr", "Error: First name format incorrect");
            request.getRequestDispatcher("account.jsp").include(request, response);
            
        } else if (!validator.validateName(lastName)){
            session.setAttribute("lastNameErr", "Error: Last name format incorrect");
            request.getRequestDispatcher("account.jsp").include(request, response);
 
        } else if (found == true) {
            session.setAttribute("existErr", "Email already exists in database");
            
        } else {
            try {
                
                manager.updateUser(firstName, lastName, email, phoneNumber, password);
                request.getRequestDispatcher("account.jsp").include(request, response);
                
            }catch (SQLException ex) {
                session.setAttribute("addErr", "Error: User couldn't be added");
                Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
