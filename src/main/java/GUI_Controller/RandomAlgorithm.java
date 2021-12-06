package GUI_Controller;

import GUI_Usecase.TextAdventureMap;
import entity.*;

import java.util.List;
import java.util.Random;

public class RandomAlgorithm {
    private TextAdventureMap textAdventureMap;
    private final Random random;

    public RandomAlgorithm(TextAdventureMap textAdventureMap){
        this.textAdventureMap = textAdventureMap;
        this.random = new Random();
    }

    public void setTextAdventureMap(TextAdventureMap textAdventureMap) {
        this.textAdventureMap = textAdventureMap;
    }

    public TextAdventureMap getTextAdventureMap() {
        return textAdventureMap;
    }

    public BasePokemon encounter(PokemonBook pokemonBook){
        List<List<String>> pokemons = textAdventureMap.getPokemons();
        int rarity = getRarity();
        if (pokemons.get(rarity).size() > 0){
            List<String> rarityPokemons = pokemons.get(rarity);
            String pokemonName = rarityPokemons.get(random.nextInt(rarityPokemons.size()));
            return pokemonBook.getPokemon(pokemonName);
        }
        return null;
    }

    public int randomExp(){
        int diff = textAdventureMap.getMAX_ExperiencePoint() - textAdventureMap.getMIN_ExperiencePoint();
        return random.nextInt(diff) + textAdventureMap.getMIN_ExperiencePoint();
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
