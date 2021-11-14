package UISimple;

import entity.User;
import usecase.UserManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserReadWriter {
    private final String filePath = "gamedata/userinfo.ser";
    private final ReadWriter rw = new ReadWriter();

    public ArrayList<User> read() throws IOException, ClassNotFoundException {
        return (ArrayList<User>) rw.read(filePath);
    }

    public void write(List<User> users) throws IOException {
        rw.write(filePath, users);
    }
}
