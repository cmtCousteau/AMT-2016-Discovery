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
     * Gestion des requête "GET", redirigie simplement la requête
     * sur la page de login.
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
     * Gestiond de la requête "POST", gère le login de l'utilisateur et la
     * création de la session.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Récupération du username et du mot de pass.
        String userName = request.getParameter("userName");
        String password = request.getParameter("password"); 
      
        // Récupération de l'id de l'utilisateur.
        int id = usersManager.getIdFromUserName(userName);
        
        // Si on à une id différente de -1 c'est que l'utilisateur existe.
        if(id != -1){
            // Si l'utilisateur arrive à se logger on ouvre une session.
            if(usersManager.passwordMatch(id, password)){
                // Création de la session.
                request.getSession().setAttribute("user", usersManager.findUser(id));
                request.getRequestDispatcher("WEB-INF/pages/welcome.jsp").forward(request, response);
                
                // à changer dans une future proche (en rajoutant un servlet).
                //response.sendRedirect("WEB-INF/pages/welcome.jsp");
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
