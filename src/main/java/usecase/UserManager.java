package usecase;

import entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
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
        if (hasUser(username)) {
            return null;
        } else {
            User user = new User(username, password);
            addUser(user);
            return user;
        }
    }
}