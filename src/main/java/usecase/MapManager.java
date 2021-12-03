package usecase;

import entity.*;

import java.util.ArrayList;

public class MapManager {
    private PokemonDataManager pokemonDataManager;
    private ArrayList<Pmap> pmaps;
    private Pmap currentPlace;

    public MapManager() {
        this.pokemonDataManager = new PokemonDataManager();
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

    public String getName(Pmap map) {
        return map.getMapName();
    }


}
