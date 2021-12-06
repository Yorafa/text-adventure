package gateway;

import entity.GameData;
import usecase_data.IReadWriter;

import java.io.IOException;

public class GameDataReadWriter implements IReadWriter {
    private final String filePath;
    private final ReadWriter rw = new ReadWriter();

    public GameDataReadWriter(String username) {
        this.filePath = "gamedata/game/" + username + ".ser";
    }

    @Override
    public GameData read() throws IOException, ClassNotFoundException {
        return (GameData) rw.read(filePath);
    }

    @Override
    public void write(Object o) throws IOException {
        rw.write(filePath, o);
    }
}
