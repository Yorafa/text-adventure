package entity;

import java.io.Serializable;


public class User implements Serializable {
    private String username;
    private String password;

    /**
     * Construct a User with all null value
     */
    public User() {
        this.username = null;
        this.password = null;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        User u = (User) o;
        return u.getUsername().equals(this.getUsername())
                && u.getPassword().equals(this.getPassword());
    }
}