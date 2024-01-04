package controller;

import driver.GameDriver;
import presenter.ExplorePresenter;
import usecase_battle.BattleManager;
import usecase_data.GameDataManager;
import usecase_map.MapManager;
import usecase_pokemon.PokemonManager;

import java.util.Scanner;

/**
 * This is the main panel that player will always see
 * Player can heal, change current place,
 * walk around to meet pokemon, and log out at this panel
 */
public class TextExplorePanel extends TextPanel {
    private final MapManager mapManager;
    private final PokemonManager pokemonManager;
    private final GameDataManager gameDataManager;
    private final ExplorePresenter explorePresenter;

    /**
     * Construct a TextExplorePanel, given them the given input, gameDriver, mapManager,
     * pokemonManager and gameDataManager
     *
     * @param input           the player input
     * @param gameDriver      the main driver of game
     * @param mapManager      the manager of map
     * @param pokemonManager  the manager of pokemon
     * @param gameDataManager the manager of game data
     *                        <p>
     *                        The relative classes
     * @see GameDriver
     * @see MapManager
     * @see PokemonManager
     * @see GameDataManager
     * @see PanelState
     */
    public TextExplorePanel(Scanner input, GameDriver gameDriver, MapManager mapManager,
                            PokemonManager pokemonManager, GameDataManager gameDataManager) {
        super(input, gameDriver);
        this.mapManager = mapManager;
        this.pokemonManager = pokemonManager;
        this.gameDataManager = gameDataManager;
        this.explorePresenter = new ExplorePresenter();
    }

    /**
     * Call presenter to show what action player can do
     */
    @Override
    protected void printMenu() {
        explorePresenter.addWalkAround();
        explorePresenter.addHeal();
        explorePresenter.addChangePlace();
        explorePresenter.addViewPocket();
        explorePresenter.addLogout();
        explorePresenter.printAllEnum();
    }

    /**
     * Read player's input and execute the respective action
     *
     * @param choice the string that player input
     */
    @SuppressWarnings("EnhancedSwitchMigration")
    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1": // Walk around
                BattleManager battleManager = new BattleManager(pokemonManager.getBattlePokemon(),
                        mapManager.walkAround(pokemonManager));
                if (battleManager.isBattling()) {
                    gameDriver.changeStateBattle(battleManager);
                    explorePresenter.printOpponent(battleManager.getP2Name());
                } else {
                    explorePresenter.printNothingHappens();
                }
                break;
            case "2": // Heal
                pokemonManager.healAll();
                explorePresenter.printHealed();
                break;
            case "3": // Change place
                gameDriver.changeState(new TextChangePlacePanel(input, gameDriver, mapManager));
                break;
            case "4":
                gameDriver.changeState(new TextPocketPanel(input, gameDriver, pokemonManager));
                break;
            case "5": // Logout
                explorePresenter.printLogout();
                gameDataManager.saveGameData(pokemonManager.getPocket(), mapManager.getCurrentPlace());
                gameDriver.changeStateLogin();
                break;
            default:
                explorePresenter.notValid();
        }
    }
}