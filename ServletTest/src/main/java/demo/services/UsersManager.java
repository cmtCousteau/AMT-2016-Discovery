/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.services;

import demo.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public final class UsersManager {
    
    // faire une map
    private static List userList = new ArrayList();
    
    public static void addUser(User user){
        userList.add(user);
    }
    public static void removeUser(User user){
        userList.remove(user);
    }
    
    public static List getUsersList(){
        List userListToReturn;
        
        userListToReturn = userList;
        return userListToReturn;
    }
    
}
