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
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
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
    
    public UserDTO(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    } 
}
