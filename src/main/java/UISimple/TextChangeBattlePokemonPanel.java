package UISimple;

import usecase.IPocketInfoAdder;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextChangeBattlePokemonPanel extends TextPanel {
    private PokemonManager pokemonManager;
    private PocketPresenter pocketPresenter;
    private IPocketInfoAdder adder;

    public TextChangeBattlePokemonPanel(Scanner input, GameController gameController, PokemonManager pokemonManager, IPocketInfoAdder adder) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.pocketPresenter = new PocketPresenter();
        this.adder = adder;
    }

    @Override
    protected void printMenu() {
        pocketPresenter.addPocketInfo(pokemonManager.getPocketInfo(adder));
        pocketPresenter.addBack();
        pocketPresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        try {
            int numChoice = Integer.parseInt(choice) - 1;
            if (numChoice >= 0 && numChoice < pokemonManager.getPocket().size()) {
                pokemonManager.setBattlePokemon(numChoice);
                pocketPresenter.printBattlePokemonChanged(pokemonManager.getBattlePokemonName());
                gameController.changeState(new TextPocketPanel(input, gameController, pokemonManager, adder));
            } else if (numChoice == pokemonManager.getPocket().size()) { // Cancel
                gameController.changeState(new TextPocketPanel(input, gameController, pokemonManager, adder));
            } else {
                pocketPresenter.notValid();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            pocketPresenter.notValid();
        }
    }
}