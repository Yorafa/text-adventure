package usecase_data;

import entity.GameData;
import gateway.ReadWriter;

import java.io.IOException;

/**
 * the data access object in charge of gameData
 */
public class GameDataReadWriterForTest implements IReadWriter {
    final ReadWriter rw = new ReadWriter();

    /**
     * @return the saved game data
     * @throws IOException            file not found exception
     * @throws ClassNotFoundException class not found exception
     */
    @Override
    public GameData read() throws IOException, ClassNotFoundException {
        String filePath = "test_data/game/testuser.ser";
        return (GameData) rw.read(filePath);
    }

    /**
     * @param o the object will be written
     * @throws IOException file not found exception
     */
    @Override
    public void write(Object o) throws IOException {
        String filePath = "test_data/game/testuser.ser";
        rw.write(filePath, o);
    }
}