package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pocket implements Serializable, Iterable<Pokemon> {
    private final List<Pokemon> pokemons;
    private Pokemon battlePokemon;

    public Pocket() {
        pokemons = new ArrayList<>();
    }

    public Pokemon getBattlePokemon() {
        return battlePokemon;
    }

    public void setBattlePokemon(Pokemon battlePokemon) {
        this.battlePokemon = battlePokemon;
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public Iterator<Pokemon> iterator() {
        return pokemons.iterator();
    }

    public int size() {
        return pokemons.size();
    }

    public Pokemon get(int i) {
        return pokemons.get(i);
    }
}