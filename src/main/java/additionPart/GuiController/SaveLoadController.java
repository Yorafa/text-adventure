package additionPart.GuiController;


import additionPart.GuiUsecase.GuiGameData;
import additionPart.GuiGateway.GameDataGate;
import additionPart.GuiGateway.UserGate;
import entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaveLoadController {
    private List<GuiGameData> gameDataHistory;

    /**
     * Construct a SaveLoadController, given them the given user
     *
     * @see User
     * @see GuiGameData
     * @see UserController
     */
    public SaveLoadController(User user){
        this.gameDataHistory = new ArrayList<>();
        initial(user);
    }
    public SaveLoadController(){
        this.gameDataHistory = new ArrayList<>();
    }

    public void save(User user, GuiGameData gameData, UserController userController){
        saveGameDataMemento(user, gameData);
        saveUserController(userController);
    }

    public void saveGameDataMemento(User user, GuiGameData gameData){
        addGameDataMemento(gameData);
        String date = gameData.toString();
        String[] dateStrings = date.split(" ");
        String[] times = dateStrings[3].split(":");
        String time = times[0] + "-" + times[1];
        date = time + dateStrings[1] + dateStrings[2];
        GameDataGate.writeGameData(user, gameData, date);
    }

    public void saveUserController(UserController userController){
        UserGate.writeUM(userController);
    }

    public void addGameDataMemento(GuiGameData gameData){
        gameDataHistory.add(gameData);
    }

    public void initial(User user){
        File file = new File("GuiData/user/"  +
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

    public GuiGameData load(){
        return lastModify();
    }

    public GuiGameData lastModify(){
        GuiGameData lastData = gameDataHistory.get(0);
        for (GuiGameData gameData: gameDataHistory){
            if(gameData.getDate().getTime() > lastData.getDate().getTime()){
                lastData = gameData;
            }
        }
        return lastData;
    }
}
