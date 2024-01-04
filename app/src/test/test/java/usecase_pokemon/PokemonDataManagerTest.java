package usecase_pokemon;

import entity.BasePokemonData;
import entity.PokemonData;
import entity.PokemonType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonDataManagerTest {

    @Test
    public void testCreate() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 100, 200, 300, 400);
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        LeveledDataCalculator leveledDataCalculator = new LeveledDataCalculator();
        PokemonData pokemonData = pokemonDataManager.create(basePokemonData, 100);
        assertEquals(leveledDataCalculator.calculate(100, 100), pokemonData.getMaxHitPoint());
        assertEquals(leveledDataCalculator.calculate(200, 100), pokemonData.getAttackPoint());
        assertEquals(leveledDataCalculator.calculate(300, 100), pokemonData.getDefencePoint());
        assertEquals(leveledDataCalculator.calculate(400, 100), pokemonData.getSpeed());
    }

    @Test
    public void testUpdate() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 100, 200, 300, 400);
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        LeveledDataCalculator leveledDataCalculator = new LeveledDataCalculator();
        PokemonData pokemonData = pokemonDataManager.create(basePokemonData, 100);
        pokemonDataManager.update(pokemonData, basePokemonData, 1);
        assertEquals(leveledDataCalculator.calculate(100, 1), pokemonData.getMaxHitPoint());
        assertEquals(leveledDataCalculator.calculate(200, 1), pokemonData.getAttackPoint());
        assertEquals(leveledDataCalculator.calculate(300, 1), pokemonData.getDefencePoint());
        assertEquals(leveledDataCalculator.calculate(400, 1), pokemonData.getSpeed());
    }
}