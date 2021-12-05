package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pocket implements Serializable {
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
}
