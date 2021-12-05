package usecase_user;

import entity.User;
import usecase_data.IReadWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private List<User> users;
    private User currentUser;
    private IReadWriter readWriter;

    public UserManager(IReadWriter readWriter) {
        try {
            users = (List<User>) readWriter.read();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
        this.readWriter = readWriter;
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

    public boolean login(String username, String password) {
        if (!hasUser(username)) {
            return false;
        } else {
            User user = getUser(username);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean register(String username, String password) {
        if (hasUser(username)) {
            return false;
//        } else if (!password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")) {
//            return false;
        } else {
            User user = new User(username, password);
            currentUser = user;
            addUser(user);
            try {
                readWriter.write(users);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}