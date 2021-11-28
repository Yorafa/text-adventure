package UI;

import entity.*;
import usecase.*;
import gateway.*;

import javax.swing.*;

public class TextAdventure {

    public static void main(String[] args) {
        UserManager userManager = UserGate.readUM();
        MapManager mapManager = MapGate.readMM();
        JFrame frame = new TextAdventureFrame(userManager, mapManager);
    }
}
