package GuiUsecase;

import GuiInterface.PokemonIterator;
import entity.Pokemon;

public class GuiLibraryIterator implements PokemonIterator {
    private GuiPlayerPokemons guiPlayerPokemons;
    private int currentPosition = 0;


    public GuiLibraryIterator(GuiPlayerPokemons guiPlayerPokemons){
        this.guiPlayerPokemons = guiPlayerPokemons;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < guiPlayerPokemons.getLibrarySize();
    }

    @Override
    public Pokemon getNext() {
        if (!hasNext()){return null;}
        Pokemon pokemon = guiPlayerPokemons.getLibraryPokemon(currentPosition);
        currentPosition ++;
        return pokemon;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}