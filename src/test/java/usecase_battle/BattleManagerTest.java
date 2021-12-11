package usecase_battle;

import entity.*;
import org.junit.Test;
import presenter.BattlePresenter;
import usecase_pokemon.PokemonFactory;

import static org.junit.Assert.*;

public class BattleManagerTest {

    private Pokemon testPokemon1;
    private Pokemon testPokemon2;
    private BattleManager testBM;

    private void setUp() {
        BasePokemonData testBPD1 = new BasePokemonData(PokemonType.FIRE, 100, 40, 10, 3);
        BasePokemonData testBPD2 = new BasePokemonData(PokemonType.WATER, 100, 30, 50, 4);
        BasePokemon basePokemon1 = new BasePokemon("Test Pokemon 1", testBPD1);
        BasePokemon basePokemon2 = new BasePokemon("Test Pokemon 2", testBPD2);
        PokemonFactory pokemonFactory = new PokemonFactory();
        testPokemon1 = pokemonFactory.getPokemon(basePokemon1, 1);
        testPokemon2 = pokemonFactory.getPokemon(basePokemon2, 1);
        testBM = new BattleManager(testPokemon1, testPokemon2);
        testBM.setPresenter(new BattlePresenter());
    }


    @Test
    public void testAttack() {
        setUp();
        testBM.attack();
        DamageCalculator damageCalculator = new DamageCalculator();
        int damageNoDefense = damageCalculator.calculate(testPokemon1.getAttackPoint(), testPokemon2.getDefencePoint());
        damageCalculator.setHasDefense(true);
        int damageWithDefense = damageCalculator.calculate(testPokemon1.getAttackPoint(), testPokemon2.getDefencePoint());
        assertTrue(testPokemon2.getHitPoint() == getHitPoint(testPokemon2, damageNoDefense) ||
                testPokemon2.getHitPoint() == getHitPoint(testPokemon2, damageWithDefense));
    }

    private int getHitPoint(Pokemon pokemon, int damage) {
        return Math.max(pokemon.getMaxHitPoint() - damage, 0);
    }

    private int getHitPoint(Pokemon pokemon, int damage, int heal) {
        return Math.min(Math.max(pokemon.getMaxHitPoint() - damage + heal, 0), pokemon.getMaxHitPoint());
    }

    @Test
    public void testDefense() {
        setUp();
        testBM.defense();
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasDefense(true);
        int damage = damageCalculator.calculate(testPokemon2.getAttackPoint(), testPokemon1.getDefencePoint());
        assertTrue(testPokemon1.getHitPoint() == testPokemon1.getMaxHitPoint() ||
                testPokemon1.getHitPoint() == getHitPoint(testPokemon1, damage));
    }

    @Test
    public void testHeal() {
        setUp();
        testBM.heal();
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(testPokemon2.getAttackPoint(), testPokemon1.getDefencePoint());
        HealCalculator healCalculator = new HealCalculator();
        int heal = healCalculator.calculate(testPokemon1.getMaxHitPoint());
        assertTrue(testPokemon1.getHitPoint() == testPokemon1.getMaxHitPoint() ||
                testPokemon1.getHitPoint() == getHitPoint(testPokemon1, damage, heal));
    }

    @Test
    public void testIsBattlingAndEndBattle() {
        setUp();
        assertTrue(testBM.isBattling());
        testBM.endBattle();
        assertFalse(testBM.isBattling());
    }

    @Test
    public void testGetterAndSetter() {
        setUp();
        assertEquals(testPokemon1, testBM.getP1());
        assertEquals(testPokemon2, testBM.getP2());
        assertEquals(testPokemon1.getName(), testBM.getP1Name());
        assertEquals(testPokemon2.getName(), testBM.getP2Name());
        assertFalse(testBM.hasCounterattackP1());
        assertFalse(testBM.hasCounterattackP2());
        testBM.setHasCounterattackP1(true);
        testBM.setHasCounterattackP2(true);
        assertTrue(testBM.hasCounterattackP1());
        assertTrue(testBM.hasCounterattackP2());
    }
}
