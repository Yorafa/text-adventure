package usecase_map;

import entity.Pmap;
import entity.Pokemon;
import usecase_data.IJsonReader;
import usecase_pokemon.PokemonManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private List<Pmap> pmaps;
    private Pmap currentPlace;

    /**
     * Construct MapManager, given pmaps the value reader read
     * @param reader the data access object
     */
    public MapManager(IJsonReader<List<Pmap>> reader) {
        try {
            this.pmaps = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loop the map and store all map names into list, then
     * @return all map names in a list
     */
    public List<String> getMapNames() {
        List<String> mapNames = new ArrayList<>();
        for (Pmap pmap : pmaps) {
            mapNames.add(pmap.getMapName());
        }
        return mapNames;
    }

    /**
     * method of encounter wild pokemon
     * @param pokemonManager the manager of pokemon
     * @return a wild pokemon from current map
     */
    public Pokemon walkAround(PokemonManager pokemonManager) {
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator();
        int index = probabilityCalculator.calculate(currentPlace.getProbabilities());
        if (index == -1) {
            return null;
        } else {
            String name = currentPlace.getPokemons().get(index);
            int level = currentPlace.getLevels().get(index);
            return pokemonManager.getPokemon(name, level);
        }
    }

    /**
     * the getter method of currentPlace
     * @return current place that player at
     */
    public Pmap getCurrentPlace() {
        return currentPlace;
    }

    /**
     * the setter method of currentPlace
     * @param currentPlace new map player want to switch to
     */
    public void setCurrentPlace(Pmap currentPlace) {
        if (currentPlace != null) {
            this.currentPlace = currentPlace;
        } else {
            this.currentPlace = pmaps.get(0);
        }
    }

    /**
     * the setter method of currentPlace
     * @param i the index of map
     */
    public void setCurrentPlace(int i) {
        currentPlace = pmaps.get(i);
    }
}