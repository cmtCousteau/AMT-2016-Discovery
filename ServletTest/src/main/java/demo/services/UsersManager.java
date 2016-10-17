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
        
    public boolean addUser(User user){
        
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users VALUES (NULL,'" + user.getUserName() + "','" + user.getPassword() +"','nom','prenom','mail@')");
            
            System.out.println("-----------------------------------------------");
            System.out.println("INSERT INTO users VALUES (NULL,'" + user.getUserName()+ "','" + user.getPassword() +"','nom','prenom','mail@')");
            System.out.println("-----------------------------------------------");
            pstmt.execute();
        }
        catch(Exception e){
            
        }
        if(!userExist(user.getUserName())){    
            userList.put(user.getUserName(), user);
            return true;
        }
        return false;
    }
    public void removeUser(User user){
        
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM 'users' WHERE 'users'.'userName' = ?");
            pstmt.setString(1, user.getUserName());
           
            System.out.println("-----------------------------------------------");
            System.out.println("DELETE FROM 'users' WHERE 'users'.'userName' = " + user.getUserName() +"");
            System.out.println("-----------------------------------------------");
            
            pstmt.execute();
        }
        catch(Exception e){
            
        }
        
        
        userList.remove(user);
    }
    
    public void removeUser(String userName){
                try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM 'users' WHERE 'users'.'userName' = ?");
            pstmt.setString(1, userName);
           
            System.out.println("-----------------------------------------------");
            System.out.println("DELETE FROM 'users' WHERE 'users'.'userName' = " + userName +"");
            System.out.println("-----------------------------------------------");
            
            pstmt.execute();
        }
        catch(Exception e){
            
        }
        
        userList.remove(userName);
    }

    public User findUser(String userName){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE userName = " + userName);
            

            ResultSet rs = pstmt.executeQuery();
        }
        catch(Exception e){
            
        }
        
        return userList.get(userName);
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
