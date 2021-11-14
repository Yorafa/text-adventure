package UISimple;

import usecase.UserManager;

import java.io.*;

public class UserReadWriter {
    private final String filePath = "gamedata/userinfo.ser";
    private final ReadWriter rw = new ReadWriter();

    public UserManager read() throws IOException, ClassNotFoundException {
        return (UserManager) rw.read(filePath);
    }

    public void write(UserManager userManager) throws IOException {
        rw.write(filePath, userManager);
    }
}
