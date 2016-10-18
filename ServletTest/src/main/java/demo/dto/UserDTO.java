/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dto;

/**
 *
 * @author marco
 */
public class UserDTO {

 
    private int id;
    private String userName;
    private String password;
    private String last_name;
    private String first_name;
    private String email;
    
    public void setEmail(String email) {
        this.email = email;
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
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public UserDTO() {
    } 
    
    public UserDTO(int id, String userName, String password, String first_name, String last_name, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    } 
}
