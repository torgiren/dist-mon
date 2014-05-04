/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * class holding user session
 * @author Maciej
 */
@Component
@Scope(value = "session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Ses {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
