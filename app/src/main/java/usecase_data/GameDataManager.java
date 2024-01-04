package usecase_data;

import entity.GameData;
import entity.Pmap;
import entity.Pocket;

import java.io.IOException;

public class GameDataManager {
    private IReadWriter readWriter;
    private GameData gameData;

    /**
     * the setter method of readWriter
     * use the readWriter to read game data
     *
     * @param readWriter the data access object
     */
    public void setReadWriter(IReadWriter readWriter) {
        this.readWriter = readWriter;
        try {
            gameData = (GameData) readWriter.read();
        } catch (IOException | ClassNotFoundException e) {
            gameData = new GameData();
        }
    }

    /**
     * method use save game data in locale file
     *
     * @param pocket the container of pokemon for player
     * @param pmap   the map player current at
     */
    public void saveGameData(Pocket pocket, Pmap pmap) {
        gameData.setPocket(pocket);
        gameData.setCurrentPlace(pmap);
        try {
            readWriter.write(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * the getter method
     *
     * @return the container of pockmons for player
     */
    public Pocket getPocket() {
        return gameData.getPocket();
    }

    /**
     * the getter method
     *
     * @return the map player current at
     */
    public Pmap getCurrentPlace() {
        return gameData.getCurrentPlace();
    }
}