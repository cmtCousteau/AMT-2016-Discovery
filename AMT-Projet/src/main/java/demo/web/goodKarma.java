/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author oem
 */
public class goodKarma extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet goodKarma</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            
            out.println("</body>");
            out.println("</html>");
             String addresse = "http://localhost:8090/api";
            
            
            JSONObject jsonLogin = new JSONObject();
            jsonLogin.put("name", "MyTest");
            jsonLogin.put("password", "password");
            
            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
            HttpPost requestHttpPostLogin;

            requestHttpPostLogin = new HttpPost(addresse+"/login");  
            StringEntity paramsLogin = new StringEntity(jsonLogin.toString());
            
            requestHttpPostLogin.addHeader("content-type", "application/json");
            
            requestHttpPostLogin.setEntity(paramsLogin);
            HttpResponse responseHttpResponse = httpClient.execute(requestHttpPostLogin);
            
            HttpEntity entity = responseHttpResponse.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            
             out.print(responseString);
            
            JSONObject obj = new JSONObject(responseString);
            out.println("mytoken" + obj.getString("token")); //John
           
            
            JSONObject jsonPS = new JSONObject();
            jsonPS.put("name", "karma"); 
   
            HttpClient httpClientPS = HttpClientBuilder.create().build(); //Use this instead 
            HttpPost requestHttpPostPS;
            
           

            requestHttpPostPS = new HttpPost(addresse+"/pointScales");
            StringEntity paramsPS = new StringEntity(jsonPS.toString());
            requestHttpPostPS.addHeader("content-type", "application/json");
            requestHttpPostPS.addHeader("token", obj.getString("token"));
          
            requestHttpPostPS.setEntity(paramsPS);
            HttpResponse responseHttpResponsePS = httpClientPS.execute(requestHttpPostPS);
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
