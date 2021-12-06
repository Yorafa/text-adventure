package GuiController;


import GuiUsecase.GuiGameData;
import GuiGateway.GameDataGate;
import entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveLoadController {
    private List<GuiGameData> gameDataHistory;
    private User relativeUser;

    public SaveLoadController(User user){
        this.gameDataHistory = new ArrayList<>();
        relativeUser = user;
        initial(user);
    }
    public SaveLoadController(){
        this.gameDataHistory = new ArrayList<>();
        relativeUser = null;
    }

    public void saveGameDataMemento(User user, GuiGameData gameData){
        addGameDataMemento(gameData);
        GameDataGate.writeGameData(user, gameData, new Date().toString());}

    public void addGameDataMemento(GuiGameData gameData){
        gameDataHistory.add(gameData);
    }
    public void initial(User user){
        File file = new File("gamedata/GuiData/user/"  +
                user.getUsername());
        File[] files = file.listFiles();
        assert files != null;
        for (File file1: files){
            addGameDataMemento(GameDataGate.readGameData(file1));
        }
    }

    public List<GuiGameData> getGameDataHistory() {
        return gameDataHistory;
    }

    public void setGameDataHistory(List<GuiGameData> gameDataHistory) {
        this.gameDataHistory = gameDataHistory;
    }

    public GuiGameData load(String date){
        return GameDataGate.readGameData(relativeUser, date);
    }

    public User getRelativeUser() {
        return relativeUser;
    }

    public void setRelativeUser(User relativeUser) {
        this.relativeUser = relativeUser;
    }
}
