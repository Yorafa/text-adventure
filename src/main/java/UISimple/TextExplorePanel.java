package UISimple;

import entity.Pmap;
import entity.Pokemon;
import usecase.BattleManager;
import usecase.MapManager;
import usecase.PokemonManager;

import java.util.List;
import java.util.Scanner;

public class TextExplorePanel extends TextPanel implements PanelState {
    private MapManager mapManager;
    private PokemonManager pokemonManager;
    private ExplorePresenter explorePresenter;

    public TextExplorePanel(Scanner input, GameController gameController, MapManager mapManager, PokemonManager pokemonManager) {
        super(input, gameController);
        this.mapManager = mapManager;
        this.pokemonManager = pokemonManager;
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
                    gameController.changeState(new TextBattlePanel(input, gameController, pokemonManager,
                            battleManager));
                } else {
                    explorePresenter.printNothingHappens();
                }
                break;
            case "2":
                pokemonManager.healAll();
                explorePresenter.printHealed();
                break;
            case "3":
                explorePresenter.printChangePlace();
                changePlace();
                break;
            case "4":
                explorePresenter.printLogout();
                break;
            default:
                explorePresenter.notValid();
        }
    }

    public void changePlace() {
        List<Pmap> maps = mapManager.getMaps();
        TextChangePlacePanel changePlacePanel = new TextChangePlacePanel(input, gameController, maps, mapManager);
        changePlacePanel.run();
        mapManager.setCurrentPlace(changePlacePanel.getNewPlace());
    }
}
