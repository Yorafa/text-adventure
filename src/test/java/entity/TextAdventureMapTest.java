package entity;

import GuiUsecase.TextAdventureMap;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextAdventureMapTest {
    TextAdventureMap textAdventureMap;

    @Before
    public void setPmap(){
        textAdventureMap = new TextAdventureMap();
    }

    @Test(timeout = 50)
    public void testSetMapNameAndGetMapName(){
       this.textAdventureMap.setMapName("MAP");
       assertEquals("MAP", textAdventureMap.getMapName());
    }

    @Test(timeout = 50)
    public void testSetPokemonsAndGetPokemons(){
        List<List<String>> pokemonList = new ArrayList<>();
        List<String> rarity = new ArrayList<>();
        rarity.add("pokemonName");
        pokemonList.add(rarity);
        this.textAdventureMap.setPokemons(pokemonList);
        assertEquals(pokemonList, textAdventureMap.getPokemons());
    }

    @Test(timeout = 50)
    public void testConstant(){
        assertEquals(0, textAdventureMap.getMAX_ExperiencePoint());
        assertEquals(0, textAdventureMap.getMIN_ExperiencePoint());
    }

    @Test(timeout = 50)
    public void testEqual(){
        TextAdventureMap textAdventureMapTest = new TextAdventureMap();
        assertTrue(textAdventureMap.equals(textAdventureMapTest));
    }
}
