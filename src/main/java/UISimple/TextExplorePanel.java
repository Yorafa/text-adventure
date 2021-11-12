package UISimple;

import usecase.MapManager;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextExplorePanel extends TextPanel {
    private PokemonManager pokemonManager;
    private MapManager mapManager;

    public TextExplorePanel(Scanner input, PanelRunner panelRunner, PokemonManager pokemonManager) {
        super(input, panelRunner);
        options.add("1. Walk around");
        options.add("2. Change place");
        options.add("3. Logout");
        this.pokemonManager = pokemonManager;
        this.mapManager = new MapManager();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                panelRunner.runBattlePanel(pokemonManager);
                break;
            case "2":
                System.out.println("A list of maps");
                panelRunner.runExplorePanel(pokemonManager);
                break;
            case "3":
                panelRunner.runLoginPanel();
                break;
            default:
                System.out.println("Not valid");
                panelRunner.runExplorePanel(pokemonManager);
        }
    }
}
