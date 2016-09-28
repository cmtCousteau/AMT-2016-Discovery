/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import demo.model.User;
import demo.services.UsersManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class CreateAccount extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/CreateAccount.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        User userTmp = UsersManager.findUser(userName);
        if(userTmp != null){
            request.setAttribute(("error"), "Error, username already used !");
        }
        else{
            UsersManager.addUser(new User(userName, password));
            request.setAttribute(("error"), "");
        }
        
        request.getRequestDispatcher("WEB-INF/pages/CreateAccount.jsp").forward(request, response);
    }


}
