package driver;

import controller.PanelState;
import controller.TextBattlePanel;
import controller.TextExplorePanel;
import controller.TextLoginPanel;
import gateway.GameDataReadWriter;
import gateway.MapJsonReader;
import gateway.PokemonJsonReader;
import gateway.UserReadWriter;
import usecase_battle.BattleManager;
import usecase_data.GameDataManager;
import usecase_map.MapManager;
import usecase_pokemon.PokemonManager;
import usecase_user.UserManager;

import java.util.Scanner;

public class GameDriver {
    private final Scanner input = new Scanner(System.in);
    private final UserManager userManager;
    private final PokemonManager pokemonManager;
    private final MapManager mapManager;
    private final GameDataManager gameDataManager;
    private PanelState state;
    private boolean gaming;

    public GameDriver() {
        this.userManager = new UserManager(new UserReadWriter());
        this.pokemonManager = new PokemonManager(new PokemonJsonReader());
        this.mapManager = new MapManager(new MapJsonReader());
        this.gameDataManager = new GameDataManager();
        this.state = new TextLoginPanel(input, this, userManager);
        this.gaming = true;
    }

    public void run() {
        while (gaming) {
            state.run();
        }
    }

    public void changeState(PanelState state) {
        this.state = state;
    }

    public void changeStateLogin() {
        changeState(new TextLoginPanel(input, this, userManager));
    }

    public void changeStateExplore() {
        changeState(new TextExplorePanel(input, this, mapManager, pokemonManager, gameDataManager));
    }

    public void changeStateExplore(String username) {
        gameDataManager.setReadWriter(new GameDataReadWriter(username));
        mapManager.setCurrentPlace(gameDataManager.getCurrentPlace());
        pokemonManager.setPocket(gameDataManager.getPocket());
        changeState(new TextExplorePanel(input, this, mapManager, pokemonManager, gameDataManager));
    }

    public void changeStateBattle(BattleManager battleManager) {
        changeState(new TextBattlePanel(input, this, pokemonManager, battleManager));
    }

    public void endGame() {
        this.gaming = false;
    }
}