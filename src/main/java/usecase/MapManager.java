package usecase;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MapManager {
    private PokemonDataManager pokemonDataManager;
    private List<Pmap> pmaps;
    private Pmap currentPlace;

    public MapManager() {
        this.pokemonDataManager = new PokemonDataManager();
        this.pmaps = new ArrayList<>();
    }

    public MapManager(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public List<Pmap> getMaps() {
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

    public List<String> getMapNames() {
        List<String> mapNames = new ArrayList<>();
        for (Pmap pmap : pmaps) {
            mapNames.add(pmap.getMapName());
        }
        return mapNames;
    }

    public Pokemon walkAround() {
        // TODO: return a random (according to the probability of currentPlace) pokemon.
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1000, 1000, 1000, 1000);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pf = new PokemonFactory();
        return pf.getPokemon(basePokemon, 0, 1000);
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

    public void setCurrentPlace(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public void setCurrentPlace(int i) {
        currentPlace = pmaps.get(i);
    }

    public String getName(Pmap map) {
        return map.getMapName();
    }


}
