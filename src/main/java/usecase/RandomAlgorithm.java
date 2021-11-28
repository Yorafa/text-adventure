package usecase;

import entity.BasePokemon;
import entity.Pmap;
import entity.Pokemon;
import entity.PokemonBook;

import java.util.List;
import java.util.Random;

public class RandomAlgorithm {
    private Pmap pmap;
    private Random random;

    public RandomAlgorithm(Pmap pmap){
        this.pmap = pmap;
        this.random = new Random();
    }

    public void setPmap(Pmap pmap) {
        this.pmap = pmap;
    }

    public Pmap getPmap() {
        return pmap;
    }

    public BasePokemon encounter(PokemonBook pokemonBook){
        List<List<String>> pokemons = pmap.getPokemons();
        int rarity = getRarity();
        List<String> rarityPokemons = pokemons.get(rarity);
        String pokemonName = rarityPokemons.get(random.nextInt(rarityPokemons.size()));
        return pokemonBook.getPokemon(pokemonName);
    }

    public int randomExp(){
        int diff = pmap.getMAX_ExperiencePoint() - pmap.getMIN_ExperiencePoint();
        return random.nextInt(diff) + pmap.getMIN_ExperiencePoint();
    }

    public int getRarity(){
        Random random = new Random();
        int rarityIdentity = random.nextInt(100);
        if (rarityIdentity == 0){
            return 0;
        }
        else if (rarityIdentity <=5){
            return 1;
        }
        else if (rarityIdentity <=40){
            return 2;
        }
        else {return 3;}
    }
}
