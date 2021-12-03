package UISimple;

import entity.User;
import usecase.IReadWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserReadWriter implements IReadWriter {
    private final String filePath = "gamedata/userinfo.ser";
    private final ReadWriter rw = new ReadWriter();

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        return rw.read(filePath);
    }

    @Override
    public void write(Object o) throws IOException {
        rw.write(filePath, o);
    }

}
