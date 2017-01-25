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
 * * @author Marco Monzione - Simon Baehler
 */
@Stateless
public class UsersManager {
    
    @Resource(lookup = "java:/amtdb")
    private DataSource dataSource;
            
    /**
     * Permet d'ajouter un utilisateur dans la base de données.
     * 
     * @param user
     * @return true/false en fonction de la réussite de l'opération.
     */
    public boolean addUser(User user){
        try{
            // Vérifie qu'un utilisateur avec le même username n'est pas déjà 
            // présent dans la base de données.
            if(!userExist(getIdFromUserName(user.getUserName()))){
                Connection connection = dataSource.getConnection();
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
        
    /**
     * Supprime un utilisateur de la base de données en fonction de son ID.
     * 
     * @param id
     */
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

    /**
     *
     *  Met un jour TOUS les champs d'un utilisateur dans la base de données
     * (sauf son id).
     * 
     * @param id
     * @param newUserName
     * @param newPassword
     * @param first_name
     * @param last_name
     * @param email
     */
    public void updateUser(int id, String newUserName, String newPassword, String first_name, String last_name, String email){
    
         try{
            Connection connection = dataSource.getConnection();
           
            PreparedStatement pstmt = connection.prepareStatement("UPDATE users SET userName = ?,user_password = ?, first_name = ?, last_name = ?, email = ? WHERE user_id = ?");
            pstmt.setString(1, newUserName);
            pstmt.setString(2, newPassword); 
            pstmt.setString(3, first_name);
            pstmt.setString(4, last_name);
            pstmt.setString(5, email);
            
            pstmt.setInt(6, id); 
            
            pstmt.execute();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Cherche un utilisateur dans la base de données en fonction de son id.
     * 
     * @param id
     * @return l'utilisateur trouver, sinon NULL.
     */
    public User findUser(int id){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            pstmt.setInt(1, id); 
            ResultSet rs = pstmt.executeQuery();
            //TODO make my JDBC code generic
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
        
    /**
     * Vérifie si un utilisateur existe en fonction de son id.
     * @param id
     * @return true/false en fonction du résultat.
     */
    public boolean userExist(int id){
        
        if(findUser(id) == null)
            return false;
        else
            return true;
    }
    
    /**
     * Vérifie si un utilisateur existe en fonction de son username.
     * @param userName
     * @return true/false en fonction du résultat.
     */
    public boolean userExist(String userName){
    
         // En fait on essaye de trouver l'id correspondant au username
         // dans la base de données, si on reçoit -1 c'est que l'utilisateur
         // n'existe pas.
        if(getIdFromUserName(userName) == -1)
            return false;
        else
            return true;
        
    }
    
    /**
     * Test si le password reçu est celui de l'utilisateur correspondant à
     * l'id reçu en paramètre.
     * 
     * @param id
     * @param password
     * @return true/false en fonction du résultat.
     */
    public boolean passwordMatch(int id, String password){
        if(userExist(id)){
            if(findUser(id).getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    /**
     * 
     * @return la liste complète des utilisateurs contenus dans la base
     * de données.
     */
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
    
    /**
     * Récupère l'id d'un utilisateur en fonction de son username.
     * @param userName
     * @return l'id de l'utilisateur en cas de succès, -1 sinon.
     */
    public int getIdFromUserName(String userName){
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE userName = ?");
            pstmt.setString(1, userName); 
            ResultSet rs = pstmt.executeQuery();
            
            if(!rs.next())
                return -1;
            
            rs.first();
            return rs.getInt("user_id");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return -1;    
    }
}
