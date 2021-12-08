package usecase_pokemon;

import entity.BasePokemonData;
import entity.Pokemon;
import entity.PokemonData;
import entity.PokemonType;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExperiencePointCalculatorTest {

    @Test
    public void testCalculate() {
        ExperiencePointCalculator experiencePointCalculator = new ExperiencePointCalculator();
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 100, 200, 300, 400);
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        PokemonData pokemonData = pokemonDataManager.create(basePokemonData, 100);
        Pokemon pokemon = new Pokemon("Pikachu", basePokemonData, 100, 10000, 100, pokemonData);
        assertEquals(2000, experiencePointCalculator.calculate(pokemon));
    }
}