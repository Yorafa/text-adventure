package usecase;

import entity.Pmap;
import entity.Pokemon;

import java.util.List;
import java.util.Random;

public class RandomAlgorithm {
    private Pmap pmap;
    public RandomAlgorithm(Pmap pmap){
        this.pmap = pmap;
    }

    public void setPmap(Pmap pmap) {
        this.pmap = pmap;
    }

    public Pmap getPmap() {
        return pmap;
    }

    public Pokemon encounter(){
        List<List<Pokemon>> pokemons = pmap.getPokemons();
        int rarity = getRarity();
        Random random = new Random();
        List<Pokemon> rarityPokemons = pokemons.get(rarity);
        return rarityPokemons.get(random.nextInt(rarityPokemons.size()));
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
