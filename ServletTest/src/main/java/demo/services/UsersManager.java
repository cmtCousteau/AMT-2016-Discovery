/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.services;

import demo.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author marco
 */

@Stateless
public class UsersManager {
    
    
    @Resource(lookup = "java:/jdbc/amtdb")
    private DataSource dataSource;
            
    public boolean addUser(User user){
        try{
            if(!userExist(getIdFromUserName(user.getUserName()))){
                Connection connection = dataSource.getConnection();
                //PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users VALUES (NULL,'" + user.getUserName() + "','" + user.getPassword() +"','nom','prenom','mail@')");
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users VALUES (NULL,?,?,?,?,?)");
                pstmt.setString(1, user.getUserName());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getFirst_name());
                pstmt.setString(4, user.getLast_name());
                pstmt.setString(5, user.getEmail());
                
                pstmt.execute();
                return true;
            }
            else
                return false;
        }
        catch(Exception e){
            
        }
        
        return false;
    }
        
    public void removeUser(int id){
        
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM users WHERE user_id = ?");
            pstmt.setInt(1, id);           
            pstmt.execute();
        }
        catch(Exception e){
            
        }
    }

    public void updateUser(int id, String newUserName, String newPassword){
    
         try{
            Connection connection = dataSource.getConnection();
           
            PreparedStatement pstmt = connection.prepareStatement("UPDATE users SET userName = ?, user_password = ? WHERE user_id = ?");
            pstmt.setString(1, newUserName);
            pstmt.setString(2, newPassword); 
            pstmt.setInt(3, id); 
            
            pstmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public User findUser(int id){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            pstmt.setInt(1, id); 
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next() ) {
                rs.first();
                return new User(rs.getInt("user_id"),
                                rs.getString("userName"),
                                rs.getString("user_password"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"));
            }
            return null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
        
    public boolean userExist(int id){
        
        if(findUser(id) == null)
            return false;
        else
            return true;
    }
    
    public boolean passwordMatch(int id, String password){
        if(userExist(id)){
            if(findUser(id).getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public Collection <User> getUsersListArray(){
        
        Collection <User> userList= new ArrayList();
        
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                userList.add(new User(rs.getInt("user_id"),
                                      rs.getString("userName"),
                                      rs.getString("user_password"),
                                      rs.getString("first_name"),
                                      rs.getString("last_name"),
                                      rs.getString("email")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return userList;
    }
    
    public int getIdFromUserName(String userName){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE userName = ?");
            pstmt.setString(1, userName); 
            ResultSet rs = pstmt.executeQuery();
            
            // FAIRE UN TEST VALEUR DE RETOUR !!!!!!!!!!!!!!!!!!!!!!
            
            rs.first();
            return rs.getInt("user_id");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return -1;    
    }
    
}
