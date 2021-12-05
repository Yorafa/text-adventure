package usecase;

import entity.Pokemon;

import java.util.Map;

public class PocketInfoAdderDetail implements IPocketInfoAdder {
    @Override
    public void add(Map<String, String> pokemonInfo, Pokemon pokemon) {
        pokemonInfo.put("name", pokemon.getName());
        pokemonInfo.put("pokemonType", String.valueOf(pokemon.getPokemonType()));
        pokemonInfo.put("level", String.valueOf(pokemon.getLevel()));
        pokemonInfo.put("experiencePoint", String.valueOf(pokemon.getExperiencePoint()));
        pokemonInfo.put("hitPoint", String.valueOf(pokemon.getHitPoint()));
        pokemonInfo.put("maxHitPoint", String.valueOf(pokemon.getMaxHitPoint()));
        pokemonInfo.put("attackPoint", String.valueOf(pokemon.getAttackPoint()));
        pokemonInfo.put("defencePoint", String.valueOf(pokemon.getDefencePoint()));
        pokemonInfo.put("speed", String.valueOf(pokemon.getSpeed()));
    }
}
