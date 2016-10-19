/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import demo.services.UsersManager;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco Monzione - Simon Baehler
 */

public class LoginServlet extends HttpServlet {

    @EJB
    private UsersManager usersManager;
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); 
      
        int id = usersManager.getIdFromUserName(userName);
        
        if(id != -1){
            // Si l'utilisateur arrive à se logger on ouvre une session.
            if(usersManager.passwordMatch(id, password)){
                // Création de la session.
                request.getSession().setAttribute("user", usersManager.findUser(id));
                request.getRequestDispatcher("WEB-INF/pages/welcome.jsp").forward(request, response);
                //response.sendRedirect(userName);
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
