package addition_part.GuiController;

import addition_part.GuiUsecase.TextAdventureMap;
import entity.*;

import java.util.List;
import java.util.Random;

public class RandomAlgorithm {
    private final TextAdventureMap textAdventureMap;
    private final Random random;

    /**
     * Construct a RandomAlgorithm, given them the given textAdventureMap
     * @param textAdventureMap see TextAdventureMap
     * @see TextAdventureMap
     */
    public RandomAlgorithm(TextAdventureMap textAdventureMap){
        this.textAdventureMap = textAdventureMap;
        this.random = new Random();
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
