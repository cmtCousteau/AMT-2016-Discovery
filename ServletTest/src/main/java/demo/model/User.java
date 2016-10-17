/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

/**
 *
 * @author marco
 */
public class User {

    private int id;
    private String last_name;
    private String first_name;
    private String userName;
    private String password;
    private String email;

    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }
    
    public int getId() {
        return id;
    }

    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
 
}
