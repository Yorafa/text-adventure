package UI;

import gateway.*;
import usecase.*;

import javax.swing.*;

public class TextAdventure {
    public static void main(String[] args) {
        UserManager userManager = UserGate.readUM();
        MapManager mapManager = new MapManager();
        MapGate.writeMM(mapManager);

    }
}
