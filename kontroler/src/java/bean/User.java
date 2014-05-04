/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * holds information about user login and password
 * @author Maciej
 */
public class User {
    private String password; 
    private String userLogin; 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

}
