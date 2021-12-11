package entity;

import java.io.Serializable;

/**
 * the player's information
 */
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

    /**
     * the getter method of username
     *
     * @return the username player
     */
    public String getUsername() {
        return username;
    }

    /**
     * the setter method of username
     *
     * @param username the given username from player
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * the getter method of password
     *
     * @return the password player use to set
     */
    public String getPassword() {
        return password;
    }

    /**
     * the setter method of password
     *
     * @param password the given password from player
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param o the object use compare
     * @return true if the object share all the data the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        User u = (User) o;
        return u.getUsername().equals(this.getUsername())
                && u.getPassword().equals(this.getPassword());
    }
}