package usecase;

import entity.Pokemon;

import java.util.Map;

public class PocketInfoAdderSimple implements IPocketInfoAdder {
    @Override
    public void add(Map<String, String> pokemonInfo, Pokemon pokemon) {
        pokemonInfo.put("name", pokemon.getName());
        pokemonInfo.put("level", String.valueOf(pokemon.getLevel()));
    }
}
