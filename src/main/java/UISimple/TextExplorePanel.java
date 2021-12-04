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
        explorePresenter.addLogout();
        explorePresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                BattleManager battleManager = new BattleManager(pokemonManager.getBattlePokemons(),
                        mapManager.walkAround());
                if (battleManager.isBattling()) {
                    gameController.changeStateBattle(battleManager);
                } else {
                    explorePresenter.printNothingHappens();
                }
                break;
            case "2":
                pokemonManager.healAll();
                explorePresenter.printHealed();
                break;
            case "3":
                gameController.changeState(new TextChangePlacePanel(input, gameController, mapManager));
                break;
            case "4":
                explorePresenter.printLogout();
                gameDataManager.saveGameData(pokemonManager.getPocket(), mapManager.getCurrentPlace());
                gameController.changeStateLogin();
                break;
            default:
                explorePresenter.notValid();
        }
    }
}
