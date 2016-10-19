/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.dto;

/**
 *
 * @author Marco Monzione - Simon Baehler
 */
public class UserDTO {

 
    private int id;
    private String userName;
    private String password;
    private String last_name;
    private String first_name;
    private String email;
    
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     *
     * @return
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }
    
    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     *
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return ID de l'utilisateur.
     */
    public int getId() {
        return id;
    }

    /**
     *
     */
    public UserDTO() {
    } 
    
    /**
     *
     * @param id ID unique de l'utilisateur.
     * @param userName pseudo de l'utilisateur.
     * @param password mot de pass de l'utilisateur.
     * @param first_name prénom de l'utilisateur.
     * @param last_name nom famille de l'utilisateur.
     * @param email email de l'utilisateur.
     */
    public UserDTO(int id, String userName, String password, String first_name, String last_name, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    } 
}
