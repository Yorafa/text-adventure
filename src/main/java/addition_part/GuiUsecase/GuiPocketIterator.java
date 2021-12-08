package addition_part.GuiUsecase;

import addition_part.GuiInterface.PokemonIterator;
import entity.Pokemon;

public class GuiPocketIterator implements PokemonIterator {
    private final GuiPlayerPokemons guiPlayerPokemons;
    private int currentPosition = 0;

    public GuiPocketIterator(GuiPlayerPokemons guiPlayerPokemons) {
        this.guiPlayerPokemons = guiPlayerPokemons;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < guiPlayerPokemons.getPocketSize();
    }

    @Override
    public Pokemon getNext() {
        if (!hasNext()) {
            return null;
        }
        Pokemon pokemon = guiPlayerPokemons.getPocketPokemon(currentPosition);
        currentPosition++;
        return pokemon;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
