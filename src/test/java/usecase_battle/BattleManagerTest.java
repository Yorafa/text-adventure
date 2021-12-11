package usecase_battle;

import entity.BasePokemonData;
import entity.Pokemon;
import entity.PokemonData;
import entity.PokemonType;
import org.junit.Test;

public class BattleManagerTest {
    final BasePokemonData testBPD1 = new BasePokemonData(PokemonType.FIRE,
            100, 40, 10, 3);
    final BasePokemonData testBPD2 = new BasePokemonData(PokemonType.WATER,
            100, 30, 50, 4);

    final PokemonData testPD1 = new PokemonData(PokemonType.FIRE, 1, 1, 1, 1);
    final PokemonData testPD2 = new PokemonData(PokemonType.WATER, 2, 2, 2, 2);

    final Pokemon testPokemon1 = new Pokemon("Test Pokemon 1", testBPD1, 2, 2, 100, testPD1);
    final Pokemon testPokemon2 = new Pokemon("Test Pokemon 2", testBPD2, 1, 1, 100, testPD2);

    BattleManager testBM = new BattleManager(testPokemon1, testPokemon2);

    @Test
    public void attackTest() {
    }
}
