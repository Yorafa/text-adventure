package usecase_data;

import entity.GameData;
import entity.Pmap;
import entity.Pocket;

import java.io.IOException;

public class GameDataManager {
    private IReadWriter readWriter;
    private GameData gameData;

    public void setReadWriter(IReadWriter readWriter) {
        this.readWriter = readWriter;
        try {
            gameData = (GameData) readWriter.read();
        } catch (IOException | ClassNotFoundException e) {
            gameData = new GameData();
        }
    }

    public void saveGameData(Pocket pocket, Pmap pmap) {
        gameData.setPocket(pocket);
        gameData.setCurrentPlace(pmap);
        try {
            readWriter.write(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pocket getPocket() {
        return gameData.getPocket();
    }

    public Pmap getCurrentPlace() {
        return gameData.getCurrentPlace();
    }
}
