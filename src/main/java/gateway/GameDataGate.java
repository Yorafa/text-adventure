package gateway;

import entity.*;

import java.io.*;

public class GameDataGate {
    public static void writeGameData(User user, GameData gameData) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("user/" + user.getUsername() + ".ser"));
            objectOutputStream.writeObject(gameData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameData readGameData(User user) {
        GameData gameData;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("user/" + user.getUsername() + ".ser"));
            try {
                gameData = (GameData) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                gameData = new GameData();
            }
        } catch (IOException e) {
            e.printStackTrace();
            gameData = new GameData();
        }
        return gameData;
    }

}
