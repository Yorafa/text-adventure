package GuiController;

import entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserController implements Serializable {
    private List<User> users;
    private User currentUser;

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

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public boolean hasUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasUser(User user) {
        for (User inListUser : users) {
            if (inListUser.equals(user)) {
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

    public User getUser(User user) {
        for (User inListUser : users) {
            if (inListUser.equals(user)) {
                return inListUser;
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