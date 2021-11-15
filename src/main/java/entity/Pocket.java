package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pocket implements Serializable {
    private List<Pokemon> pokemons;
    private List<Pokemon> battlePokemons;

    public Pocket() {
        pokemons = new ArrayList<>();
    }

    public void setBattlePokemons(List<Pokemon> battlePokemons) {
        this.battlePokemons = battlePokemons;
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

}
