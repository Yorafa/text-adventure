package Gui_gateway;


import GUI_Usecase.GuiGameData;
import entity.User;

import java.io.*;

public class GameDataGate {
    public static void writeGameData(User user, GuiGameData gameData) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("GUI_Data/user/" + user.getUsername() + ".ser"));
            objectOutputStream.writeObject(gameData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GuiGameData readGameData(User user) {
        GuiGameData gameData;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("GUI_Data/user/"  + user.getUsername() + ".ser"));
            try {
                gameData = (GuiGameData) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                gameData = new GuiGameData();
            }
        } catch (IOException e) {
            e.printStackTrace();
            gameData = new GuiGameData();
        }
        return gameData;
    }

}
