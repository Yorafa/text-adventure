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

/**
 * The main driver that connect and call all controllers and presenters
 */
public class GameDriver {
    private final Scanner input = new Scanner(System.in);
    private final UserManager userManager;
    private final PokemonManager pokemonManager;
    private final MapManager mapManager;
    private final GameDataManager gameDataManager;
    private PanelState state;
    private boolean gaming;

    /**
     * Construct a GameDriver, given them new variable
     *
     * The relative classes
     * @see UserManager
     * @see PanelState
     * @see PokemonManager
     * @see BattleManager
     * @see TextLoginPanel
     * @see GameDataManager
     * @see MapManager
     */
    public GameDriver() {
        this.userManager = new UserManager(new UserReadWriter());
        this.pokemonManager = new PokemonManager(new PokemonJsonReader());
        this.mapManager = new MapManager(new MapJsonReader());
        this.gameDataManager = new GameDataManager();
        this.state = new TextLoginPanel(input, this, userManager);
        this.gaming = true;
    }

    /**
     * method use run this game
     */
    public void run() {
        while (gaming) {
            state.run();
        }
    }

    /**
     * Use change panel
     *
     * @param state panel(words) that will be showed in the shell to player
     *
     * @see PanelState
     */
    public void changeState(PanelState state) {
        this.state = state;
    }

    /**
     * call changeState switch to log in panel
     *
     * @see TextLoginPanel
     */
    public void changeStateLogin() {
        changeState(new TextLoginPanel(input, this, userManager));
    }

    /**
     * call changeState switch to explore panel
     *
     * @see TextExplorePanel
     */
    public void changeStateExplore() {
        changeState(new TextExplorePanel(input, this, mapManager, pokemonManager, gameDataManager));
    }

    /**
     * load player last state, set player into the map last in
     * call changeState switch to explore panel
     *
     * @param username the player's name
     *
     * @see TextExplorePanel
     */
    public void changeStateExplore(String username) {
        gameDataManager.setReadWriter(new GameDataReadWriter(username));
        mapManager.setCurrentPlace(gameDataManager.getCurrentPlace());
        pokemonManager.setPocket(gameDataManager.getPocket());
        changeStateExplore();
    }

    /**
     * call changeState switch to battle panel
     *
     * @param battleManager the manage in charge of pokemon battle
     *
     * @see TextBattlePanel
     */
    public void changeStateBattle(BattleManager battleManager) {
        changeState(new TextBattlePanel(input, this, pokemonManager, battleManager));
    }

    /**
     * method use stop game
     */
    public void endGame() {
        this.gaming = false;
    }
}