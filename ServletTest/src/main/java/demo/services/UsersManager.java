/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.services;

import demo.dto.UserDTO;
import demo.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.sql.DataSource;

/**
 *
 * @author marco
 */

@Singleton
public class UsersManager {
    
    
    @Resource(lookup = "java:/jdbc/amtdb")
    private DataSource dataSource;
    
    
    // faire une map
    //private static List userList = new MapList();
    private Map<String, User> userList = new HashMap<>();
        
    public void addUser(User user){
        userList.put(user.getUserName(), user);
    }
    public void removeUser(User user){
        userList.remove(user);
    }
    
    public void removeUser(String userName){
        userList.remove(userName);
    }

    public User findUser(String userName){
     /*   try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE userName = " + userName);
            ResultSet rs = pstmt.executeQuery();
        }
        catch(Exception e){
            
        }*/
        
        return userList.get(userName);
    }
    
    public boolean addUser(String userName, String password){
    
        if(!userExist(userName)){
            addUser(new User(userName, password));
            return true;
        }
        return false;
    }
    
    public boolean userExist(String userName){
        
        if(findUser(userName) == null)
            return false;
        else
            return true;
    }
    
    public boolean passwordMatch(String userName, String password){
        if(userExist(userName)){
            if(findUser(userName).getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public Collection <User> getUsersListArray(){
        return userList.values();
    }
    
}
