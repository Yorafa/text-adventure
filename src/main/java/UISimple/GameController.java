package UISimple;

import entity.GameData;
import entity.Pmap;
import entity.Pocket;
import entity.PokemonBook;
import usecase.GameDataManager;
import usecase.MapManager;
import usecase.PokemonManager;

import java.io.Serializable;
import java.util.Scanner;

public class GameController {
    private Scanner input;
    private PokemonManager pokemonManager;
    private MapManager mapManager;

    public GameController(Scanner input) {
        this.input = input;
        this.pokemonManager = new PokemonManager();
        this.mapManager = new MapManager();
    }

    public GameController(Scanner input, GameData gameData) {
        this.input = input;
        GameDataManager gameDataManager = new GameDataManager();
        Pocket pocket = gameDataManager.getPocket(gameData);
        this.pokemonManager = new PokemonManager(pocket);
        Pmap currentPlace = gameDataManager.getCurrentPlace(gameData);
        this.mapManager = new MapManager(currentPlace);
    }

    public void run() {
        TextExplorePanel explorePanel = new TextExplorePanel(input, mapManager, pokemonManager);
        TextBattlePanel battlePanel;

        while (!explorePanel.isLoggedOut()) {
            explorePanel.runPanel();
            if (!explorePanel.isExploring()) {
                battlePanel = new TextBattlePanel(input, pokemonManager, explorePanel.getPokemon());
                if (battlePanel.isBattling()) {
                    battlePanel.runPanel();
                }
                explorePanel.continueExploring();
            }
        }
    }

    public GameData getGameData() {
        Pocket pocket = pokemonManager.getPocket();
        Pmap currentPlace = mapManager.getCurrentPlace();
        GameDataManager gameDataManager = new GameDataManager();
        return gameDataManager.getGameData(pocket, currentPlace);
    }
}
