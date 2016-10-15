/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.rest;

import demo.dto.UserDTO;
import demo.model.User;
import demo.services.UsersManager;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author marco
 */
@Stateless
@Path("/usersManagerTest")
public class UsersManagerRest {
    
    @EJB
    private UsersManager usersManager;
    
    @Context
    UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection <UserDTO> getUsers(){
        
        Collection <UserDTO> userListDTO = new ArrayList();
        
        for(User u : usersManager.getUsersListArray()){
            userListDTO.add(toDTO(u));
        }

        return userListDTO;

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO){

        URI href;
        
        if(usersManager.findUser(userDTO.getUserName()) == null){
            usersManager.addUser(fromDTO(userDTO));
            href = uriInfo.getBaseUriBuilder()
                            .path(UsersManagerRest.class)
                            .path(UsersManagerRest.class, "getUser")
                            .build(userDTO.getUserName());
            return Response.created(href).build();
        }
        else{
            return Response.status(418).build();
        }
        
        
        
  
    }
    
    @Path("{userName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("userName") String userName){
        User user = usersManager.findUser(userName);
        return toDTO(user);
    } 
    
    @Path("{userName}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("userName") String userName, UserDTO userDTO){
        User userTmp = usersManager.findUser(userName);
        
        
        userTmp.setPassword(userDTO.getPassword());
        // Pose problème de changer le userName, car c'est la clé dans la map.
        // userTmp.setUserName(userDTO.getUserName());
    } 
    
    @Path("{userName}")
    @DELETE
    public void deleteUser(@PathParam("userName") String userName){
        usersManager.removeUser(userName);
    }  
    
    
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getUserName(), userDTO.getPassword());
    }
    
    public UserDTO toDTO(User user){
        return new UserDTO(user.getUserName(), user.getPassword());
    }
    
    
}
