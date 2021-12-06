package usecase_user;

import entity.User;
import usecase_data.IReadWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private List<User> users;
    private IReadWriter readWriter;

    public UserManager(IReadWriter readWriter) {
        try {
            users = (List<User>) readWriter.read();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
        this.readWriter = readWriter;
    }

    private void addUser(User user) {
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

    private User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean login(String username, String password) {
        if (!hasUser(username)) {
            return false;
        } else {
            User user = getUser(username);
            assert user != null;
            return user.getPassword().equals(password);
        }
    }

    public boolean register(String username, String password) {
        if (hasUser(username)) {
            return false;
//        } else if (!password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")) {
//            return false;
        } else {
            User user = new User(username, password);
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