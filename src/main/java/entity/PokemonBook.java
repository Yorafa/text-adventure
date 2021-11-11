package entity;

import java.util.ArrayList;
import java.util.List;

public class PokemonBook {
    private List<BasePokemon> pokemonBook;

    public PokemonBook() {
        this.pokemonBook = new ArrayList<>();
    }

    public void addPokemon(BasePokemon pokemon) {
        pokemonBook.add(pokemon);
    }

    public void removePokemon(int i) {
        pokemonBook.remove(i);
    }
}
