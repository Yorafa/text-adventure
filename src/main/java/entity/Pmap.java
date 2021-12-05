package entity;

import java.io.Serializable;
import java.util.List;

public class Pmap implements Serializable {
    private String mapName;
    private List<String> pokemons;
    private List<Integer> probabilities;
    private List<Integer> levels;

    public String getMapName() {
        return mapName;
    }

    public List<String> getPokemons() {
        return pokemons;
    }

    public List<Integer> getProbabilities() {
        return probabilities;
    }

    public List<Integer> getLevels() {
        return levels;
    }
}
