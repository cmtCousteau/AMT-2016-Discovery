/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import demo.model.User;
import demo.services.UsersManager;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */

public class LoginServlet extends HttpServlet {

    @EJB
    private UsersManager usersManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean userLoginOk = false;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); 
      
        int id = usersManager.getIdFromUserName(userName);
        
        if(usersManager.userExist(id)){
            // Si l'utilisateur arrive à se logger on ouvre une session.
            if(usersManager.passwordMatch(id, password)){
                // Création de la session.
                request.getSession().setAttribute("user", usersManager.findUser(id));
            }
            else{
                 request.setAttribute("error", "username/password is wrong");
                 
            }
        }
        else{
             request.setAttribute("error", "user doesn't exist !");
        }
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

}
