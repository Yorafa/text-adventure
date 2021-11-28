package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PmapTest {
    Pmap pmap;

    @Before
    public void setPmap(){
        pmap = new Pmap();
    }

    @Test(timeout = 50)
    public void testSetMapNameAndGetMapName(){
       this.pmap.setMapName("MAP");
       assertEquals("MAP",pmap.getMapName());
    }

    @Test(timeout = 50)
    public void testSetPokemonsAndGetPokemons(){
        List<List<String>> pokemonList = new ArrayList<>();
        List<String> rarity = new ArrayList<>();
        rarity.add("pokemonName");
        pokemonList.add(rarity);
        this.pmap.setPokemons(pokemonList);
        assertEquals(pokemonList, pmap.getPokemons());
    }

    @Test(timeout = 50)
    public void testConstant(){
        assertEquals(0, pmap.getMAX_ExperiencePoint());
        assertEquals(0, pmap.getMIN_ExperiencePoint());
    }

    @Test(timeout = 50)
    public void testEqual(){
        Pmap pmapTest = new Pmap();
        assertTrue(pmap.equals(pmapTest));
    }
}
