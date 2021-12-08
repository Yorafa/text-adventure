package addition_part.GuiController;


import entity.GameData;
import entity.Pmap;
import entity.Pocket;
import entity.User;
import gateway.GameDataReadWriter;
import usecase_data.GameDataManager;
import usecase_user.UserManager;

import java.util.Date;
import java.util.HashMap;

public class SaveLoadController {
    private final HashMap<Date, GameData> gameDataHistory;
    private final GameDataManager gameDataManager = new GameDataManager();
    private GameData gameData;

    /**
     * Construct a SaveLoadController, given them the given user
     *
     * @see User
     * @see GameData
     * @see UserManager
     */
    public SaveLoadController(){
        this.gameDataHistory = new HashMap<>();
        gameData = new GameData();
    }

    public void setReadWriter(String username){
        gameDataManager.setReadWriter(new GameDataReadWriter(username));
        gameData.setPocket(gameDataManager.getPocket());
        gameData.setCurrentPlace(gameDataManager.getCurrentPlace());
    }

    public void addGameDataMemento(Pocket pocket, Pmap pmap) {
        GameData gameData = new GameData();
        gameData.setCurrentPlace(pmap);
        gameData.setPocket(pocket);
        gameDataHistory.put(new Date(), gameData);
    }

    public void loadGameDataMemento(Date date){
        gameData = gameDataHistory.get(date);
    }

    public void saveGameData(Pocket pocket, Pmap pmap){
        gameDataManager.saveGameData(pocket, pmap);
    }

    public Pmap getCurrentPlace() {
        return gameData.getCurrentPlace();
    }

    public Pocket getPocket() {
        return gameData.getPocket();
    }

    public HashMap<Date, GameData> getGameDataHistory() {
        return gameDataHistory;
    }
}
