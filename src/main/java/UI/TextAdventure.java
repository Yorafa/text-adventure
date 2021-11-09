package UI;

import controller.UserManager;
import gateway.UserGate;

import javax.swing.*;

public class TextAdventure {
    public static void main(String[] args){
        UserManager userManager = UserGate.readUM();
        JFrame frame = new TextAdventureFrame(userManager);

    }
}
