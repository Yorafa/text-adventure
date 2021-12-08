package entity;

import java.io.Serializable;
import java.util.List;

/**
 * The map of game
 */
public class Pmap implements Serializable {
    private String mapName;
    private List<List<String>> pokemons;
    private List<Integer> levels; // this list should only store 2 value

    /**
     * the getter method of mapName
     * @return the name of this map
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * the getter method of pokemons
     * @return a list of Pokemon's name from this map
     */
    public List<List<String>> getPokemons() {
        return pokemons;
    }

    /**
     * the getter method of levels
     * @return the level range that pokemon from this map could be
     */
    public List<Integer> getLevels() {
        return levels;
    }
}