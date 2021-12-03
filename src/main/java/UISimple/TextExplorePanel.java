package UISimple;

import entity.Pmap;
import entity.Pokemon;
import usecase.MapManager;
import usecase.PokemonManager;

import java.util.List;
import java.util.Scanner;

public class TextExplorePanel extends TextPanel implements PanelState {
    private MapManager mapManager;
    private PokemonManager pokemonManager;
    private Pokemon pokemon;
    private boolean loggedOut;
    private boolean exploring;

    public TextExplorePanel(Scanner input, MapManager mapManager, PokemonManager pokemonManager) {
        super(input);
        options.add("1. Walk around");
        options.add("2. Heal Pokemons");
        options.add("3. Change place");
        options.add("4. Logout");
        this.mapManager = mapManager;
        this.pokemonManager = pokemonManager;
        this.loggedOut = false;
        this.exploring = true;
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                pokemon = mapManager.walkAround();
                if (pokemon == null) {
                    System.out.println("Nothing happens.");
                    run();
                } else {
                    exploring = false;
                }
                break;
            case "2":
                pokemonManager.healAll();
                System.out.println("All pokemons are healed.");
                break;
            case "3":
                System.out.println("Where do you want to go?");
                changePlace();
                run();
                break;
            case "4":
                System.out.println("You are logged out.");
                loggedOut = true;
                break;
            default:
                System.out.println("Not valid");
                run();
        }
    }

    public void changePlace() {
        List<Pmap> maps = mapManager.getMaps();
        TextChangePlacePanel changePlacePanel = new TextChangePlacePanel(input, maps, mapManager);
        changePlacePanel.run();
        mapManager.setCurrentPlace(changePlacePanel.getNewPlace());
    }

    public boolean isLoggedOut() {
        return loggedOut;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void continueExploring() {
        this.exploring = true;
    }

    public boolean isExploring() {
        return exploring;
    }
}
