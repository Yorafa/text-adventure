package UISimple;

import java.io.*;

public class GameDataReadWriter {
    private final String filePath;
    private final ReadWriter rw = new ReadWriter();
    private String username;

    public GameDataReadWriter(String username) {
        this.username = username;
        this.filePath = "gamedata/game/" + username + ".ser";
    }

    public GameController read() throws IOException, ClassNotFoundException {
        return (GameController) rw.read(filePath);
    }

    public void write(GameController gameController) throws IOException {
        rw.write(filePath, gameController);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
