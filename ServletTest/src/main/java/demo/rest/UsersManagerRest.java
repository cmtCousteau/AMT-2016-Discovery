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
 * @author Marco Monzione - Simon Baehler
 */
@Stateless
@Path("/usersManagerTest")
public class UsersManagerRest {
    
    @EJB
    private UsersManager usersManager;
    
    @Context
    UriInfo uriInfo;
    
    /**
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection <UserDTO> getUsers(){
        
        Collection <UserDTO> userListDTO = new ArrayList();
        
        for(User u : usersManager.getUsersListArray()){
            userListDTO.add(toDTO(u));
        }

        return userListDTO;
    }

    /**
     *
     * @param userDTO
     * @return
     */
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
    
    /**
     *
     * @param id
     * @return
     */
    @Path("{user_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("user_id") int id){
        User user = usersManager.findUser(id);
        return toDTO(user);
    } 
    
    /**
     *
     * @param id
     * @param userDTO
     * @return 
     */
    @Path("{user_id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("user_id") int id, UserDTO userDTO){
        
        URI href;
        
        if(usersManager.userExist(id)){
            usersManager.updateUser(id,
                                    userDTO.getUserName(),
                                    userDTO.getPassword(), 
                                    userDTO.getFirst_name(), 
                                    userDTO.getLast_name(), 
                                    userDTO.getEmail());
            
            href = uriInfo.getBaseUriBuilder()
                            .path(UsersManagerRest.class)
                            .path(UsersManagerRest.class, "getUser")
                            .build(userDTO.getId());
            return Response.created(href).build();
        }
        else
            return Response.status(404).build();
    } 
    
    /**
     *
     * @param id
     * @return 
     */
    @Path("{user_id}")
    @DELETE
    public Response deleteUser(@PathParam("user_id") int id){
        
        URI href;
        
        if(usersManager.userExist(id)){
            usersManager.removeUser(id);
            return Response.status(204).build();
        }
        else
            return Response.status(404).build();
    }  

    /**
     *
     * @param userDTO
     * @return
     */
    public User fromDTO(UserDTO userDTO){
        
        return new User(userDTO.getId(),
                        userDTO.getUserName(),
                        userDTO.getPassword(),
                        userDTO.getFirst_name(),
                        userDTO.getLast_name(),
                        userDTO.getEmail());
    }
    
    /**
     *
     * @param user
     * @return
     */
    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(),
                           user.getUserName(),
                           user.getPassword(), // A voir !!!!!!!!!!!!!!
                           user.getFirst_name(),
                           user.getLast_name(),
                           user.getEmail());
    }
    
    
}
