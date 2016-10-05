/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import demo.services.UsersManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class UsersManagerServlet extends HttpServlet {
    
    @EJB
    private UsersManager usersManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("usersList", usersManager.getUsersListArray());
        request.getRequestDispatcher("WEB-INF/pages/usersManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/usersManager.jsp").forward(request, response);;
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        
        if(userName != null){
            if(usersManager.userExist(userName))
                usersManager.removeUser(usersManager.findUser(userName));            
        }
        request.getRequestDispatcher("WEB-INF/pages/usersManager.jsp").forward(request, response);
    }
}
