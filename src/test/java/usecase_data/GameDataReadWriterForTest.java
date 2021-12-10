package usecase_data;

import entity.GameData;
import gateway.ReadWriter;

import java.io.IOException;

/**
 * the data access object in charge of gameData
 */
public class GameDataReadWriterForTest implements IReadWriter {
    String username;
    ReadWriter rw = new ReadWriter();

    /**
     * Construct a GameDataReadWriter, given the username
     *
     * @param username the player's username
     */
    public GameDataReadWriterForTest(String username) {
        this.username = username;
    }

    /**
     *
     * @return the saved game data
     * @throws IOException file not found exception
     * @throws ClassNotFoundException class not found exception
     */
    @Override
    public GameData read() throws IOException, ClassNotFoundException {
        String filePath = "test_data/testuser.ser";
        return (GameData) rw.read(filePath);
    }

    /**
     *
     * @param o the object will be written
     * @throws IOException file not found exception
     */
    @Override
    public void write(Object o) throws IOException {
        String filePath = "test_data/testuser.ser";
        rw.write(filePath, o);
    }
}