package entity;

import java.util.ArrayList;
import java.util.List;

public class PokemonBook {
    private final List<BasePokemon> pokemonBook;

    public PokemonBook() {
        this.pokemonBook = new ArrayList<>();
    }

    public void addPokemon(BasePokemon pokemon) {
        pokemonBook.add(pokemon);
    }

    public void removePokemon(int i) {
        pokemonBook.remove(i);
    }

    public List<BasePokemon> getPokemonBook() {
        return pokemonBook;
    }

    public BasePokemon get(int i) {
        return pokemonBook.get(i);
    }

    public BasePokemon get(String name) {
        for (BasePokemon basePokemon : pokemonBook) {
            if (basePokemon.getName().equals(name)) {
                return basePokemon;
            }
        }
        return null;
    }
}
