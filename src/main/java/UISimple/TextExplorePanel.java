package UISimple;

import usecase.BattleManager;
import usecase.GameDataManager;
import usecase.MapManager;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextExplorePanel extends TextPanel implements PanelState {
    private MapManager mapManager;
    private PokemonManager pokemonManager;
    private GameDataManager gameDataManager;
    private ExplorePresenter explorePresenter;

    public TextExplorePanel(Scanner input, GameController gameController, MapManager mapManager,
                            PokemonManager pokemonManager, GameDataManager gameDataManager) {
        super(input, gameController);
        this.mapManager = mapManager;
        this.pokemonManager = pokemonManager;
        this.gameDataManager = gameDataManager;
        this.explorePresenter = new ExplorePresenter();
    }

    @Override
    protected void printMenu() {
        explorePresenter.addWalkAround();
        explorePresenter.addHeal();
        explorePresenter.addChangePlace();
        explorePresenter.addViewPocket();
        explorePresenter.addLogout();
        explorePresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1": // Walk around
                BattleManager battleManager = new BattleManager(pokemonManager.getBattlePokemon(),
                        mapManager.walkAround(pokemonManager));
                if (battleManager.isBattling()) {
                    gameController.changeStateBattle(battleManager);
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
                gameController.changeState(new TextChangePlacePanel(input, gameController, mapManager));
                break;
            case "4":
                gameController.changeState(new TextPocketPanel(input, gameController, pokemonManager));
                break;
            case "5": // Logout
                explorePresenter.printLogout();
                gameDataManager.saveGameData(pokemonManager.getPocket(), mapManager.getCurrentPlace());
                gameController.changeStateLogin();
                break;
            default:
                explorePresenter.notValid();
        }
    }
}