/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.rest;

import demo.dto.UserDTO;
import demo.model.User;
import demo.services.UsersManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
        
        
        if(usersManager.addUser(fromDTO(userDTO))){
            
            userDTO.setId(usersManager.getIdFromUserName(userDTO.getUserName()));
            href = uriInfo.getBaseUriBuilder()
                            .path(UsersManagerRest.class)
                            .path(UsersManagerRest.class, "getUser")
                            .build(userDTO.getId());
            return Response.created(href).build();
        }
        else{
            return Response.status(418).build();
        }
    }
    
    @Path("{user_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("user_id") int id){
        User user = usersManager.findUser(id);
        return toDTO(user);
    } 
    
    @Path("{user_id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("user_id") int id, UserDTO userDTO){
        
        usersManager.updateUser(id, userDTO.getUserName(), userDTO.getPassword());
    } 
    
    @Path("{user_id}")
    @DELETE
    public void deleteUser(@PathParam("user_id") int id){
        usersManager.removeUser(id);
    }  

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getUserName(), userDTO.getPassword());
    }
    
    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getUserName(), user.getPassword());
    }
    
    
}
