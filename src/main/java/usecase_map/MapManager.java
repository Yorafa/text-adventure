package usecase_map;

import entity.*;
import usecase_data.IJsonReader;
import usecase_pokemon.PokemonManager;

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
}
