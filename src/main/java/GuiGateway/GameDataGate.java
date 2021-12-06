package GuiGateway;


import GuiUsecase.GuiGameData;
import entity.User;

import java.io.*;

public class GameDataGate {
    public static void writeGameData(User user, GuiGameData gameData, String date) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("gamedata/GuiData/user/" + user.getUsername() + "/"+ date +".ser"));
            objectOutputStream.writeObject(gameData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GuiGameData readGameData(User user, String date) {
        GuiGameData gameData;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("gamedata/GuiData/user/"  +
                            user.getUsername() + "/"+ date +"gameData.ser"));
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

    public static GuiGameData readGameData(File file) {
        GuiGameData gameData;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file));
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
