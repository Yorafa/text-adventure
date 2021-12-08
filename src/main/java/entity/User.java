package entity;

import java.io.Serializable;


public class User implements Serializable {
    private final String username;
    private final String password;

    /**
     * Construct a User, given them the given username and password
     *
     * @param username the name of user
     * @param password the password of user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}