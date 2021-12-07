package additionPart.GuiController;

import entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserController implements Serializable {
    private List<User> users;
    private User currentUser;

    /**
     * Construct UserController, given them the new list and null
     */
    public UserController() {
        users = new ArrayList<>();
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean hasUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        if (!hasUser(username)) {
            return null;
        } else {
            User user = getUser(username);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
    }

    public User register(String username, String password) {
        if (hasUser(username)) {return null;}
        else if(!password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")){return null;}
        else {
            User user = new User(username, password);
            addUser(user);
            return user;
        }
    }
}