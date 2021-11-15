package UISimple;

import entity.Pokemon;
import usecase.PokemonManager;

import java.util.List;
import java.util.Scanner;

public class TextChangePokemonPanel extends TextPanel {
    private Pokemon newPokemon;
    private List<Pokemon> battlePokemons;

    public TextChangePokemonPanel(Scanner input, List<Pokemon> battlePokemons, PokemonManager pokemonManager) {
        super(input);
        this.battlePokemons = battlePokemons;
        int i = 1;
        for (Pokemon pokemon : battlePokemons) {
            options.add(i + ". " + pokemonManager.getName(pokemon));
            i++;
        }
        options.add(i + ". Cancel");
    }

    @Override
    protected void execute(String choice) {
        try {
            int choiceIndex = Integer.parseInt(choice) - 1;
            options.get(choiceIndex);
            if (choiceIndex != options.size() - 1) {
                newPokemon = battlePokemons.get(choiceIndex);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Not valid.");
            runPanel();
        }
    }

    public Pokemon getNewPokemon() {
        return newPokemon;
    }
}
