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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author oem
 */
public class giveSomeKarma extends HttpServlet {

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
            out.println("<title>Servlet giveSomeKarma</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet giveSomeKarma at " + request.getContextPath() + "</h1>");
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
            out.println("mytoken : " + obj.getString("token")); //John
            
            
            
            //getID PS
            /*HttpClient httpClientGet = HttpClientBuilder.create().build(); //Use this instead 
            HttpGet requestHttpGetPSID;
            requestHttpGetPSID = new HttpGet(addresse+"/pointScales");
            requestHttpGetPSID.addHeader("Accept", "");
            requestHttpGetPSID.addHeader("token", obj.getString("token"));
            
            HttpResponse responseHttpResponseGet = httpClientGet.execute(requestHttpGetPSID);
        
            HttpEntity entityGet = responseHttpResponseGet.getEntity();
            out.println("<p> entityGet.getContent() ->   " + entityGet.getContent());
            
            String json_string = EntityUtils.toString(responseHttpResponseGet.getEntity());
            
            out.println("<p> json_string " + json_string);
            JSONArray temp1 = new JSONArray(json_string);
            
            JSONObject objGET = null;
            for(int n = 0; n < temp1.length(); n++)
            {
                
                objGET = (JSONObject) temp1.get(n);
                out.println("name " + objGET.getString("name")); //John
                out.println("id" + objGET.getString("id")); //John
            }
           
            //out.println("name :" + objGet.getString("name")); //Joh
            
            int id = Integer.parseInt(objGET.getString("id"));
            */
             // Creation de l'event
            JSONObject jsonRules = new JSONObject();
            jsonRules.put("awardBadgeId",0);
            jsonRules.put("awardPointScaleId", 23);
            jsonRules.put("eventType", "player is kind"); 
            jsonRules.put("point", 100); 
            
            HttpClient httpClientRules = HttpClientBuilder.create().build(); //Use this instead 
            HttpPost requestHttpPostRules;
           
            requestHttpPostRules = new HttpPost(addresse+"/rules");
            StringEntity paramsRules = new StringEntity(jsonRules.toString());
            requestHttpPostRules.addHeader("content-type", "application/json");
            requestHttpPostRules.addHeader("token", obj.getString("token"));
          
            requestHttpPostRules.setEntity(paramsRules);
            HttpResponse responseHttpResponseRules = httpClientRules.execute(requestHttpPostRules);
            
               
            // Ceation de l'event
            JSONObject jsonPS = new JSONObject();
            jsonPS.put("eventType", "player is kind");
            jsonPS.put("userAppId", 5); 
   
            HttpClient httpClientPS = HttpClientBuilder.create().build(); //Use this instead 
            HttpPost requestHttpPostPS;
           
            requestHttpPostPS = new HttpPost(addresse+"/events");
            StringEntity paramsPS = new StringEntity(jsonPS.toString());
            requestHttpPostPS.addHeader("content-type", "application/json");
            requestHttpPostPS.addHeader("token", obj.getString("token"));
          
            requestHttpPostPS.setEntity(paramsPS);
            HttpResponse responseHttpResponsePS = httpClientPS.execute(requestHttpPostPS);

            //getID PS
            HttpClient httpClientGet = HttpClientBuilder.create().build(); //Use this instead 
            HttpGet requestHttpGetPSID;
            requestHttpGetPSID = new HttpGet(addresse+"/users/awards");
            requestHttpGetPSID.addHeader("Accept", "");
            requestHttpGetPSID.addHeader("token", obj.getString("token"));
            
            HttpResponse responseHttpResponseGet = httpClientGet.execute(requestHttpGetPSID);
        
            HttpEntity entityGet = responseHttpResponseGet.getEntity();
            out.println("<p> entityGet.getContent() ->   " + entityGet.getContent());
            
            String json_string = EntityUtils.toString(responseHttpResponseGet.getEntity());
            
            out.println("<p> json_string " + json_string);
            JSONArray temp1 = new JSONArray(json_string);
            
            JSONObject objGET = null;
            for(int n = 0; n < temp1.length(); n++)
            {
                
                objGET = (JSONObject) temp1.get(n);
                //out.println("name " + objGET.getString("name")); //John
                out.println("id" + objGET.getString("id")); //John
                JSONArray awardList = new JSONArray(objGET.getString("awardList"));
                for(int m = 0; m < awardList.length(); m++)
                {
                    objGET = (JSONObject) awardList.get(m);
                    out.println("<p> awardType" + objGET.getString("awardType"));
                    out.println("<p>awardDate" + objGET.getString("awardDate"));
                    out.println("<p>");
                    //out.println("awardType" + objGET.getString("awardType"));
                }
                 out.println("<p>");
                
            }
           
            //out.println("name :" + objGet.getString("name")); //Joh
            
            int id = Integer.parseInt(objGET.getString("id"));
            
            out.println("</body>");
            out.println("</html>");
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
