package controller;
import usecase.User;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private ArrayList<User> users;
    private static final long serialVersionUID = 114514;

    public UserManager(){
        users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);

    }
    public void deleteUser(User user){
        users.remove(user);
    }
    public Boolean hasUser(String name){
        int index = getIndex(name);
        return index != -1;
    }
    public int getIndex(String name){
        for (User user : users) {
            if (user.getName().equals(name)) {
                return users.indexOf(user);}}
        return -1;
    }
    public User login(String name, String password){
        int index = getIndex(name);

        if (index == -1){
            return null;}
        else {
            User user = users.get(index);
            if (user.getPassword().equals(password)){
                return user;}
            else {return null;}}
    }
    public User register(String name, String password){
        if (getIndex(name) != -1){
            return null;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        addUser(user);
        return user;
    }
}
