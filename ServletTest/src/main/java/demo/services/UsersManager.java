/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.services;

import demo.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marco
 */
public final class UsersManager {
    
    // faire une map
    //private static List userList = new MapList();
    private static Map<String, User> userList = new HashMap<>();
    
    public static void addUser(User user){
        userList.put(user.getUserName(), user);
    }
    public static void removeUser(User user){
        userList.remove(user);
    }

    public static User findUser(String userName){
        return userList.get(userName);
    }
}
