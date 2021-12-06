package gateway;

import usecase_data.IReadWriter;

import java.io.IOException;

public class UserReadWriter implements IReadWriter {
    private final String filePath = "game_data/UserInfo.ser";
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