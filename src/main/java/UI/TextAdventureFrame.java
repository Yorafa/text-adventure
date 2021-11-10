package UI;

import controller.UserManager;
import usecase.User;

import javax.swing.*;
import java.awt.*;

public class TextAdventureFrame extends JFrame {
    UserManager userManager;
    User user;


    public TextAdventureFrame(UserManager userManager) {
        this.userManager = userManager;
        this.user = null;
        // Setup frame
        this.setTitle("Text Adventure");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 450);
        this.setVisible(true);
        LoginPanel loginPanel = new LoginPanel(this);
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser(){return user;}

    public void setUserManager(UserManager userManager){this.userManager = userManager;}
    public UserManager getUserManager(){return this.userManager;}
}
