package usecase;

import entity.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private ArrayList<Pmap> pmaps;
    private Pmap currentPlace;

    public MapManager() {
        this.pmaps = new ArrayList<>();
    }

    public MapManager(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public ArrayList<Pmap> getMaps() {
        return pmaps;
    }

    public void addMap(Pmap pmap) {
        pmaps.add(pmap);
    }

    public Pmap start() {
        return pmaps.get(0);
    }

    public Pmap find(String mapName) {
        for (Pmap pmap : pmaps) {
            if (pmap.getMapName().equals(mapName)) {
                return pmap;
            }
        }
        return null;
    }

    public Pokemon walkAround() {
        // TODO: return a random (according to the probability of currentPlace) pokemon.
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 10, 10, 10, 10);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pf = new PokemonFactory();
        return pf.getPokemon(basePokemon, 1000, 10);
    }

    public List<String> getMapNames() {
        List<String> mapNames = new ArrayList<>();
        for (Pmap pmap : pmaps) {
            mapNames.add(pmap.getMapName());
        }
        return mapNames;
    }

    private Pmap getMap(String placeName) {
        for (Pmap pmap : pmaps) {
            if (pmap.getMapName().equals(placeName)) {
                return pmap;
            }
        }
        return null;
    }

    public Pmap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(String placeName) {
        currentPlace = getMap(placeName);
    }

}
