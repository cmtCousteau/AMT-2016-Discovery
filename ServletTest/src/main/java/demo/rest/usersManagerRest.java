/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.rest;

import demo.dto.UserDTO;
import demo.model.User;
import demo.services.UsersManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marco
 */
@Stateless
@Path("/usersManagerTest")
public class usersManagerRest {
    
    @EJB
    private UsersManager usersManager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        
        List<User> users = (List<User>) usersManager.getUsersListArray();
        return users;

    }
    
    public UserDTO toDTO(User user){
        return new UserDTO(user.getUserName(), user.getPassword());
    }
    
    
}
