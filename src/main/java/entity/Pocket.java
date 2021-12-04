package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Pocket implements Serializable {
    private List<Pokemon> pokemons;
    private List<Pokemon> battlePokemons;
    private HashMap<String, Integer> items;

    public Pocket() {
        pokemons = new ArrayList<>();
        battlePokemons = new ArrayList<>();
        items = new HashMap<>();
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setBattlePokemons(List<Pokemon> battlePokemons) {
        this.battlePokemons = battlePokemons;
    }

    public void setFirstPokemon(Pokemon pokemon){
        battlePokemons.remove(pokemon);
        battlePokemons.set(0, pokemon);
    }

    public List<Pokemon> getBattlePokemons() {
        return battlePokemons;
    }

    public Pokemon getDefaultPokemon() {
        return battlePokemons.get(0);
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
        return getPokemons().equals(pocket.getPokemons()) && getBattlePokemons().equals(pocket.getBattlePokemons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPokemons(), getBattlePokemons());
    }
}
