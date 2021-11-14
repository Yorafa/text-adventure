package UISimple;

import entity.PokemonBook;
import usecase.MapManager;
import usecase.PokemonManager;

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

    public void run() {
        TextExplorePanel explorePanel = new TextExplorePanel(input, mapManager);
        TextBattlePanel battlePanel;

        while (!explorePanel.isLoggedOut()) {
            explorePanel.runPanel();
            if (!explorePanel.isExploring()) {
                battlePanel = new TextBattlePanel(input, pokemonManager, explorePanel.getPokemon());
                battlePanel.runPanel();
                explorePanel.continueExploring();
            }
        }
    }

}
