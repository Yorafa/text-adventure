package gateway;

import usecase.*;

import java.io.*;

public class UserGate {
    public static void writeUM(UserManager userManager) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("gamedata/userinfo.ser"));
            objectOutputStream.writeObject(userManager);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserManager readUM() {
        UserManager userManager;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("gamedata/userinfo.ser"));
            try {
                userManager = (UserManager) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                userManager = new UserManager();
            }
        } catch (IOException e) {
            e.printStackTrace();
            userManager = new UserManager();
        }
        return userManager;
    }
}
