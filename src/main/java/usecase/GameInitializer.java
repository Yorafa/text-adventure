package usecase;

import entity.*;

public class GameInitializer {
    private Pocket pocket;
    private Pmap pmap;

    public GameInitializer() {
        this.pocket = new Pocket();
        BasePokemon pikachu = new BasePokemon("Pikachu", new BasePokemonData(PokemonType.ELECTRICITY, 1000, 1000, 1000, 1000));
        pocket.add(new PokemonFactory().getPokemon(pikachu, 15));
    }
}
