package GUI_Controller;

import GUI_Usecase.TextAdventureMap;
import entity.*;
import usecase.PokemonDataManager;
import usecase.PokemonFactory;

import java.util.ArrayList;
import java.util.List;

public class MapController{
    private List<TextAdventureMap> textAdventureMaps;
    private TextAdventureMap currentPlace;

    public MapController() {
        this.textAdventureMaps = new ArrayList<>();
        this.currentPlace = null;
    }

    public MapController(TextAdventureMap currentPlace) {
        this.textAdventureMaps = new ArrayList<>();
        this.currentPlace = currentPlace;
    }

    public void setTextAdventureMaps(List<TextAdventureMap> textAdventureMaps){
        this.textAdventureMaps = textAdventureMaps;
    }

    public List<TextAdventureMap> getMaps() {
        return textAdventureMaps;
    }

    public void addMap(TextAdventureMap textAdventureMap) {
        textAdventureMaps.add(textAdventureMap);
    }

    public TextAdventureMap start() {
        if (!textAdventureMaps.isEmpty()){return textAdventureMaps.get(0);}
        return null;
    }

    public TextAdventureMap find(String mapName) {
        for (TextAdventureMap textAdventureMap : textAdventureMaps) {
            if (textAdventureMap.getMapName().equals(mapName)) {
                return textAdventureMap;
            }
        }
        return null;
    }

    public Pokemon walkAround(PokemonBook pokemonBook) {
        RandomAlgorithm ra = new RandomAlgorithm(this.currentPlace);
        PokemonFactory pokemonFactory = new PokemonFactory();
        BasePokemon basePokemon = ra.encounter(pokemonBook);
        if (basePokemon != null) {
            return pokemonFactory.getPokemon(basePokemon, ra.randomExp());
        }
        else{
            return null;
        }
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(TextAdventureMap currentPlace) {
        this.currentPlace = currentPlace;
    }

}
