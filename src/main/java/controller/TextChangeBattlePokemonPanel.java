package controller;

import driver.GameDriver;
import presenter.PocketPresenter;
import usecase_pocket.IPocketInfoAdder;
import usecase_pokemon.PokemonManager;

import java.util.Scanner;

public class TextChangeBattlePokemonPanel extends TextPanel {
    private final PokemonManager pokemonManager;
    private final PocketPresenter pocketPresenter;
    private final IPocketInfoAdder adder;

    /**
     * This is a panel that will show when player change battle pokemon
     *
     * Construct a TextChangeBattlePokemonPanel, given them the given input, gameDriver,
     * pokemonManager and adder
     * @param input the player input
     * @param gameDriver the main driver of game
     * @param pokemonManager the manager of pokemon
     * @param adder the pocket info of player adder
     *
     * The relative classes
     * @see GameDriver
     * @see PokemonManager
     * @see IPocketInfoAdder
     * @see TextPanel
     */
    public TextChangeBattlePokemonPanel(Scanner input, GameDriver gameDriver, PokemonManager pokemonManager, IPocketInfoAdder adder) {
        super(input, gameDriver);
        this.pokemonManager = pokemonManager;
        this.pocketPresenter = new PocketPresenter();
        this.adder = adder;
    }

    /**
     * Override of TextPanel
     * Call presenter to show what action player can do
     */
    @Override
    protected void printMenu() {
        pocketPresenter.addPocketInfo(pokemonManager.getPocketInfo(adder));
        pocketPresenter.addBack();
        pocketPresenter.printAllEnum();
    }

    /**
     * Override of TextPanel
     * Read player's input and execute the respective action
     * @param choice the string that player input
     */
    @Override
    protected void execute(String choice) {
        try {
            int numChoice = Integer.parseInt(choice) - 1;
            if (numChoice >= 0 && numChoice < pokemonManager.getPocket().size()) {
                pokemonManager.setBattlePokemon(numChoice);
                pocketPresenter.printBattlePokemonChanged(pokemonManager.getBattlePokemonName());
                gameDriver.changeState(new TextPocketPanel(input, gameDriver, pokemonManager, adder));
            } else if (numChoice == pokemonManager.getPocket().size()) { // Cancel
                gameDriver.changeState(new TextPocketPanel(input, gameDriver, pokemonManager, adder));
            } else {
                pocketPresenter.notValid();
            }
        } catch (NumberFormatException e) {
            pocketPresenter.notValid();
        }
    }
}