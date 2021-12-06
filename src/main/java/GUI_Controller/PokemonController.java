package GUI_Controller;

import entity.Pokemon;

import java.util.List;

public class PokemonController {
    public static void healAll(List<Pokemon> pokemons){
        for (Pokemon pokemon: pokemons){
        pokemon.setHitPoint(pokemon.getMaxHitPoint());}
    }

    public static void reduceHp(Pokemon pokemon, int damage){
        pokemon.setHitPoint(pokemon.getHitPoint()-damage);
    }
}
