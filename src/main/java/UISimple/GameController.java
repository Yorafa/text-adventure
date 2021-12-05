package UISimple;

import usecase.*;

import java.util.Scanner;

public class GameController {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager;
    private PokemonManager pokemonManager;
    private MapManager mapManager;
    private GameDataManager gameDataManager;
    private PanelState state;
    private boolean gaming;

    public GameController() {
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