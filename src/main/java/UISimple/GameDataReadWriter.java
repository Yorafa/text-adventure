package UISimple;

import entity.GameData;

import java.io.*;

public class GameDataReadWriter {
    private final String filePath;
    private final ReadWriter rw = new ReadWriter();

    public GameDataReadWriter(String username) {
        this.filePath = "gamedata/game/" + username + ".ser";
    }

    public GameData read() throws IOException, ClassNotFoundException {
        return (GameData) rw.read(filePath);
    }

    public void write(GameData gameData) throws IOException {
        rw.write(filePath, gameData);
    }
}
