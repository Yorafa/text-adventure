package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pocket implements Serializable {
    private List<Pokemon> pokemons;
    private List<Pokemon> defaultPokemons;

    public Pocket() {
        pokemons = new ArrayList<>();
    }

    public void setDefaultPokemons(List<Pokemon> defaultPokemons) {
        this.defaultPokemons = defaultPokemons;
    }

    public List<Pokemon> getDefaultPokemons() {
        return defaultPokemons;
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

}
