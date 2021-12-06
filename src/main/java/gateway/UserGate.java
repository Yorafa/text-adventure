package gateway;

import GuiController.*;

import java.io.*;

public class UserGate {
    public static void writeUM(UserController userController) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("GuiData/userinfo.ser"));
            objectOutputStream.writeObject(userController);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserController readUM() {
        UserController userController;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("GuiData/userinfo.ser"));
            try {
                userController = (UserController) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                userController = new UserController();
            }
        } catch (IOException e) {
            e.printStackTrace();
            userController = new UserController();
        }
        return userController;
    }

}
