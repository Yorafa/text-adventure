package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonBook implements Serializable {
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

    public List<BasePokemon> getPokemonBook(){
        return pokemonBook;
    }

    public BasePokemon get(int i) {
        return pokemonBook.get(i);
    }
}
