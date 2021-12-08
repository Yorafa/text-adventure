package usecase_map;

import java.util.List;
import java.util.Random;

public class ProbabilityCalculator {

    /**
     * the probability of encounter wild pokemon
     * @param pokemonList a list of different rarity pokemon group
     * @return -1 represent nothing, of name of pokemon
     */
    public String calculate(List<List<String>> pokemonList) {
        Random r = new Random();
        int rarity = calculateRarity();
        if (pokemonList.get(rarity).size() > 0){
            List<String> rarityPokemons = pokemonList.get(rarity);
            return rarityPokemons.get(r.nextInt(rarityPokemons.size()));
        }
        return "-1";
    }

    /**
     *
     * @param levelList the level range of pokemon
     * @return the random level of pokemon
     */
    public int calculateLevel(List<Integer> levelList){
        Random r = new Random();
        int diff = levelList.get(1) - levelList.get(0);
        return r.nextInt(diff) + levelList.get(0);
    }

    private int calculateRarity(){
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
