package gateway;

import entity.GameData;
import usecase_data.IReadWriter;

import java.io.IOException;

/**
 * the data access object in charge of gameData
 */
public class GameDataReadWriter implements IReadWriter {
    private final String filePath;
    private final ReadWriter rw = new ReadWriter();

    /**
     * Construct a GameDataReadWriter, given them the given username
     *
     * @param username the player given name
     */
    public GameDataReadWriter(String username) {
        this.filePath = "game_data/game/" + username + ".ser";
    }

    /**
     *
     * @return the saved game data
     * @throws IOException file not found exception
     * @throws ClassNotFoundException class not found exception
     */
    @Override
    public GameData read() throws IOException, ClassNotFoundException {
        return (GameData) rw.read(filePath);
    }

    /**
     *
     * @param o the object will be written
     * @throws IOException file not found exception
     */
    @Override
    public void write(Object o) throws IOException {
        rw.write(filePath, o);
    }
}