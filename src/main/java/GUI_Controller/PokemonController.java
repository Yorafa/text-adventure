package GUI_Controller;

import entity.Pokemon;
import usecase.LevelCalculator;
import usecase.PokemonDataManager;

import java.util.List;

public class PokemonController {
    public static void healAll(List<Pokemon> pokemons){
        for (Pokemon pokemon: pokemons){
        pokemon.setHitPoint(pokemon.getMaxHitPoint());}
    }

    public static void reduceHp(Pokemon pokemon, int damage){
        pokemon.setHitPoint(pokemon.getHitPoint()-damage);
    }

    public static boolean canFight(List<Pokemon> pokemons){
        return pokemons.get(0).getHitPoint() > 0;
    }

    public static void getExp(List<Pokemon> pokemons, Pokemon wildPokemon){
        int exp = wildPokemon.getExperiencePoint()/pokemons.size();
        for (Pokemon pokemon: pokemons){
            pokemon.setExperiencePoint(pokemon.getExperiencePoint() + exp);
            update(pokemon);
        }
    }

    public static void update(Pokemon pokemon){
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        LevelCalculator levelCalculator = new LevelCalculator();
        pokemon.setLevel(levelCalculator.calculateLevel(pokemon.getExperiencePoint()));
        pokemonDataManager.update(pokemon.getPokemonData(),pokemon.getBasePokemonData(),pokemon.getLevel());
    }
}
