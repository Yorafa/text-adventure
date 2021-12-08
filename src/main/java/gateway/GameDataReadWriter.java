package gateway;

import entity.GameData;
import usecase_data.IReadWriter;

import java.io.IOException;

public class GameDataReadWriter implements IReadWriter {
    private final String filePath;
    private final ReadWriter rw = new ReadWriter();

    /**
     * Construct a GameDataReadWriter, given them the given username
     * @param username the player given name
     */
    public GameDataReadWriter(String username) {
        this.filePath = "game_data/game/" + username + ".ser";
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