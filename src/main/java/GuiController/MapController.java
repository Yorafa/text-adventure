package GuiController;

import GuiUsecase.TextAdventureMap;
import entity.BasePokemon;
import entity.Pokemon;
import entity.PokemonBook;
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

    public void setCurrentPlace(TextAdventureMap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public void addMap(TextAdventureMap textAdventureMap) {
        textAdventureMaps.add(textAdventureMap);
    }

    public List<TextAdventureMap> getTextAdventureMaps() {
        return textAdventureMaps;
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
            Pokemon newPokemon = pokemonFactory.getPokemon(basePokemon, ra.randomExp(), 0);
            PokemonController.heal(newPokemon);
            return newPokemon;
        }
        else{
            return null;
        }
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }


}
