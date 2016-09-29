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
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean userLoginOk = false;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); 
      
        
        User userTmp = UsersManager.findUser(userName);

        // Si l'utilisateur arrive à se logger on ouvre une session.
        if(userTmp.getPassword().equals(password)){
            
            // Création de la session.
            request.getSession().setAttribute("user", userTmp);
            request.getRequestDispatcher("WEB-INF/pages/welcome.jsp").forward(request, response);
            
        }
        else{
             request.getSession().setAttribute("error", "username/password is wrong");
             request.getRequestDispatcher("WEB-INF/pages/index.html").forward(request, response);
        }
        
        
    }

}
