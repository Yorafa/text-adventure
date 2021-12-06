package controller;

import driver.GameDriver;
import presenter.PocketPresenter;
import usecase_pocket.*;
import usecase_pokemon.PokemonManager;

import java.util.Scanner;

public class TextPocketPanel extends TextPanel implements PanelState {
    private final PokemonManager pokemonManager;
    private final PocketPresenter pocketPresenter;
    private IPocketSorter sorter;
    private IPocketInfoAdder adder;

    /**
     * Construct a TextExplorePanel, given them the given input,
     * gameDriver and pokemonManager
     *
     * @param input the player input
     * @param gameDriver the main driver of game
     * @param pokemonManager the manager of pokemon
     *
     * The relative classes
     * @see GameDriver
     * @see PanelState
     * @see PokemonManager
     */
    public TextPocketPanel(Scanner input, GameDriver gameDriver, PokemonManager pokemonManager) {
        super(input, gameDriver);
        this.pokemonManager = pokemonManager;
        this.pocketPresenter = new PocketPresenter();
        this.adder = new PocketInfoAdderSimple();
    }

    public TextPocketPanel(Scanner input, GameDriver gameDriver, PokemonManager pokemonManager, IPocketInfoAdder adder) {
        super(input, gameDriver);
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
                gameDriver.changeState(new TextChangeBattlePokemonPanel(input, gameDriver, pokemonManager, adder));
                break;
            case "6": // Back
                gameDriver.changeStateExplore();
        }
    }
}