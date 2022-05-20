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
import ioTBay.User;

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
        
        User user = (User) session.getAttribute("user");
        
        
        
        if (validator.checkEmptyRegister(firstName, lastName, email, phoneNumber, password)) {
            validator.clear(session);
            session.setAttribute("emptyErr", "Error: Please fill in all fields.");
            request.getRequestDispatcher("account.jsp").include(request, response);
            
        } else if (!validator.validateEmail(email)) { 
            validator.clear(session);
            //8-set incorrect email error to the session
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp     
            request.getRequestDispatcher("account.jsp").include(request, response);
        //10- validate password
        } else if (!validator.validatePassword(password)) {
            validator.clear(session);
            //11-set incorrect password error to the session
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp          
            request.getRequestDispatcher("account.jsp").include(request, response);
        
        } else if (!validator.validateName(firstName)) {
            validator.clear(session);
            session.setAttribute("firstNameErr", "Error: First name format incorrect");
            request.getRequestDispatcher("account.jsp").include(request, response);
            
        } else if (!validator.validateName(lastName)){
            validator.clear(session);
            session.setAttribute("lastNameErr", "Error: Last name format incorrect");
            request.getRequestDispatcher("account.jsp").include(request, response);
 
        } else {
            try {
                manager.updateUser(user.getUserID(), firstName, lastName, email, phoneNumber, password);
                user = manager.findUser(email, password);
                session.setAttribute("user", user);
                session.setAttribute("updateSucc", "Success: Account details updated");
                validator.clear(session);
                request.getRequestDispatcher("account.jsp").include(request, response);
                
            }catch (SQLException ex) {
                validator.clear(session);
                session.setAttribute("addErr", "Error: User couldn't be added");
                Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
