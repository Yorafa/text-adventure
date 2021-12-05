package UISimple;

import usecase.*;

import java.util.Scanner;

public class TextPocketPanel extends TextPanel implements PanelState {
    private PokemonManager pokemonManager;
    private PocketPresenter pocketPresenter;
    private IPocketSorter sorter;
    private IPocketInfoAdder adder;

    public TextPocketPanel(Scanner input, GameController gameController, PokemonManager pokemonManager) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.pocketPresenter = new PocketPresenter();
        this.adder = new PocketInfoAdderSimple();
    }

    public TextPocketPanel(Scanner input, GameController gameController, PokemonManager pokemonManager, IPocketInfoAdder adder) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.pocketPresenter = new PocketPresenter();
        this.adder = adder;
    }

    @Override
    protected void printMenu() {
        pocketPresenter.addPocketInfo(pokemonManager.getPocketInfo(adder));
        pocketPresenter.printAll();
        pocketPresenter.addShowDetails();
        pocketPresenter.addHideDetails();
        pocketPresenter.addSortByName();
        pocketPresenter.addSortByLevel();
        pocketPresenter.addSetBattlePokemon();
        pocketPresenter.addBack();
        pocketPresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1": // Show Details
                adder = new PocketInfoAdderDetail();
                break;
            case "2": // Hide Details
                adder = new PocketInfoAdderSimple();
                break;
            case "3": // Sort by name
                sorter = new PocketSorterByName();
                sorter.sort(pokemonManager.getPocket());
                break;
            case "4": // Sort by level
                sorter = new PocketSorterByLevel();
                sorter.sort(pokemonManager.getPocket());
                break;
            case "5": // Set battle pokemon
                gameController.changeState(new TextChangeBattlePokemonPanel(input, gameController, pokemonManager, adder));
                break;
            case "6": // Back
                gameController.changeStateExplore();
        }
    }
}