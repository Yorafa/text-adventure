package usecase;

import entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapManager {
    private List<Pmap> pmaps;
    private Pmap currentPlace;

    public MapManager(IJsonReader<List<Pmap>> reader) {
        try {
            this.pmaps = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public Pokemon walkAround(PokemonManager pokemonManager) {
        Random r = new Random();
        int i = r.nextInt(100);
        int sum = 0;
        int index = 0;
        for (int p : currentPlace.getProbabilities()) {
            sum += p;
            if (sum > i) {
                return pokemonManager.getPokemon(currentPlace.getPokemons().get(index), currentPlace.getLevels().get(index));
            } else {
                index += 1;
            }
        }
        return null;
//        // TODO: return a random (according to the probability of currentPlace) pokemon.
//        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1000, 1000, 1000, 1000);
//        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
//        PokemonFactory pf = new PokemonFactory();
//        return pf.getPokemon(basePokemon, 0, 1000);
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
        if (currentPlace != null) {
            this.currentPlace = currentPlace;
        } else {
            this.currentPlace = pmaps.get(0);
        }
    }

    public void setCurrentPlace(int i) {
        currentPlace = pmaps.get(i);
    }

    public String getName(Pmap map) {
        return map.getMapName();
    }


}
