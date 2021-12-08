package usecase_pocket;

import entity.Pokemon;

import java.util.Map;

public class PocketInfoAdderSimple implements IPocketInfoAdder {

    /**
     * add names and levels a list of pokemons
     * @param pokemonInfo the information of pokemon
     * @param pokemon pokemon
     */
    @Override
    public void add(Map<String, String> pokemonInfo, Pokemon pokemon) {
        pokemonInfo.put("name", pokemon.getName());
        pokemonInfo.put("level", String.valueOf(pokemon.getLevel()));
    }
}