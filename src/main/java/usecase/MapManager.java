package usecase;

import entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

//    public MapManager(Pmap currentPlace) {
//        this.currentPlace = currentPlace;
//    }
//
//    public List<Pmap> getMaps() {
//        return pmaps;
//    }
//
//    public void addMap(Pmap pmap) {
//        pmaps.add(pmap);
//    }
//
//    public Pmap start() {
//        return pmaps.get(0);
//    }
//
//    public Pmap find(String mapName) {
//        for (Pmap pmap : pmaps) {
//            if (pmap.getMapName().equals(mapName)) {
//                return pmap;
//            }
//        }
//        return null;
//    }

    public List<String> getMapNames() {
        List<String> mapNames = new ArrayList<>();
        for (Pmap pmap : pmaps) {
            mapNames.add(pmap.getMapName());
        }
        return mapNames;
    }

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

//    private Pmap getMap(String placeName) {
//        for (Pmap pmap : pmaps) {
//            if (pmap.getMapName().equals(placeName)) {
//                return pmap;
//            }
//        }
//        return null;
//    }

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

//    public String getName(Pmap map) {
//        return map.getMapName();
//    }


}
