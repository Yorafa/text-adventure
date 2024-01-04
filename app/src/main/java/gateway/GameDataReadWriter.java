package gateway;

import entity.GameData;
import usecase_data.IReadWriter;

import java.io.IOException;

/**
 * the data access object in charge of gameData
 */
public class GameDataReadWriter implements IReadWriter {
    private final String username;
    private final ReadWriter rw = new ReadWriter();

    /**
     * Construct a GameDataReadWriter, given the username
     *
     * @param username the player's username
     */
    public GameDataReadWriter(String username) {
        this.username = username;
    }

    /**
     * @return the saved game data
     * @throws IOException            file not found exception
     * @throws ClassNotFoundException class not found exception
     */
    @Override
    public GameData read() throws IOException, ClassNotFoundException {
        ConfigReader configReader = new ConfigReader();
        String filePath = configReader.getGamePath() + username + ".ser";
        return (GameData) rw.read(filePath);
    }

    /**
     * @param o the object will be written
     * @throws IOException file not found exception
     */
    @Override
    public void write(Object o) throws IOException {
        ConfigReader configReader = new ConfigReader();
        String filePath = configReader.getGamePath() + username + ".ser";
        rw.write(filePath, o);
    }
}