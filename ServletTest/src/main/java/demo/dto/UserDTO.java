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

    public UserDTO() {
    } 
    
    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    } 
}
