package usecase_pocket;

import entity.BasePokemonData;
import entity.Pokemon;
import entity.PokemonData;
import entity.PokemonType;

public interface PokemonForTest {
    BasePokemonData testBPD1 = new BasePokemonData(PokemonType.ELECTRICITY,
            1, 1, 1, 1);
    BasePokemonData testBPD2 = new BasePokemonData(PokemonType.GRASS,
            2, 2, 2, 2);
    BasePokemonData testBPD3 = new BasePokemonData(PokemonType.FIRE,
            3, 3, 3, 3);
    BasePokemonData testBPD4 = new BasePokemonData(PokemonType.WATER,
            4, 4, 4, 4);

    PokemonData testPD1 = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
    PokemonData testPD2 = new PokemonData(PokemonType.GRASS, 2, 2, 2, 2);
    PokemonData testPD3 = new PokemonData(PokemonType.FIRE, 3, 3, 3, 3);
    PokemonData testPD4 = new PokemonData(PokemonType.WATER, 4, 4, 4, 4);

    Pokemon testPokemon1 = new Pokemon("Test Pokemon 1", testBPD1, 4, 4, 1, testPD1);
    Pokemon testPokemon2 = new Pokemon("Test Pokemon 2", testBPD2, 3, 3, 2, testPD2);
    Pokemon testPokemon3 = new Pokemon("Test Pokemon 3", testBPD3, 2, 2, 3, testPD3);
    Pokemon testPokemon4 = new Pokemon("Test Pokemon 4", testBPD4, 1, 1, 4, testPD4);
}
