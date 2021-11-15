package usecase;

import entity.GameData;
import entity.Pmap;
import entity.Pocket;

public class GameDataManager {

    public GameData getGameData(Pocket pocket, Pmap currentPlace) {
        return new GameData(pocket, currentPlace);
    }

    public Pocket getPocket(GameData gameData) {
        return gameData.getPocket();
    }

    public Pmap getCurrentPlace(GameData gameData) {
        return gameData.getCurrentPlace();
    }
}
