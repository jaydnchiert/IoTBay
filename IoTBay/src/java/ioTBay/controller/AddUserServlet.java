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
 * @author Le
 */
public class AddUserServlet extends HttpServlet{
    
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
        Character userType = request.getParameter("userType").charAt(0);
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
            validator.clear(session);
            session.setAttribute("emptyErr", "Error: Please fill in all fields.");
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
            
        } else if (!validator.validateEmail(email)) { 
            validator.clear(session);
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp     
            request.getRequestDispatcher("register.jsp").include(request, response);
        //10- validate password
        } else if (!validator.validatePassword(password)) {  
            validator.clear(session);
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp          
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
        
        } else if (!validator.validateName(firstName)) {
            validator.clear(session);
            session.setAttribute("firstNameErr", "Error: First name format incorrect");
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
            
        } else if (!validator.validateName(lastName)){
            validator.clear(session);
            session.setAttribute("lastNameErr", "Error: Last name format incorrect");
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
 
        } else if (!validator.validatePhoneNumber(phoneNumber)) {
            validator.clear(session);
            session.setAttribute("phoneErr", "Error: Phone Number format incorrect");
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
            
        } else if (found == true) {
            validator.clear(session);
            session.setAttribute("existErr", "Error: User already exists in database");
            request.getRequestDispatcher("AddUserAdmin.jsp").include(request, response);
        } else {
            try {
                validator.clear(session);
                manager.addUser(firstName, lastName, email, phoneNumber, password, userType);
                request.getRequestDispatcher("AdminIndex.jsp").include(request, response);
                
            }catch (SQLException ex) {
                validator.clear(session);
                session.setAttribute("addErr", "Error: User couldn't be added");
                Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 }

