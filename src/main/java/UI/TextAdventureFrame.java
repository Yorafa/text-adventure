package UI;

import usecase.*;
import entity.*;

import javax.swing.*;

public class TextAdventureFrame extends JFrame {
    UserManager userManager;
    MapManager mapManager;
    User user;
    Pmap pmap;


    public TextAdventureFrame(UserManager userManager, MapManager mapManager) {
        this.userManager = userManager;
        this.mapManager = mapManager;
        this.user = null;
        this.pmap = mapManager.start();
        // Setup frame
        this.setTitle("Text Adventure");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new LoginPanel(this));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMap(Pmap pmap) {
        this.pmap = pmap;
    }

    public User getUser() {
        return user;
    }

    public Pmap getMap() {
        return pmap;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public MapManager getMapManager() {
        return mapManager;
    }
}
