package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pocket implements Serializable, Iterable<Pokemon> {
    private List<Pokemon> pokemons;
    private Pokemon battlePokemon;

    public Pocket() {
        pokemons = new ArrayList<>();
    }

    public void setBattlePokemon(Pokemon battlePokemon) {
        this.battlePokemon = battlePokemon;
    }

    public Pokemon getBattlePokemon() {
        return battlePokemon;
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pocket pocket = (Pocket) o;
        return getPokemons().equals(pocket.getPokemons()) && getBattlePokemon().equals(pocket.getBattlePokemon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPokemons(), getBattlePokemon());
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
