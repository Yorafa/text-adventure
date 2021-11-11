package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Pmap {
    private String mapName;
    private int mapId;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Long> probability;
    // Note: the two Lists are parallel so that easy catch up.

    public Pmap(){
        this.mapName = "";
        this.mapId = 0;
        this.pokemons = new ArrayList<>();
        this.probability = new ArrayList<>();
    }

    public Pmap(String mapName, int mapId){
        this.mapName = mapName;
        this.mapId = mapId;
        this.pokemons = new ArrayList<>();
        this.probability = new ArrayList<>();
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setProbability(ArrayList<Long> probability) {
        this.probability = probability;
    }

    public void addPokemon(Pokemon pokemon, long probability){
        this.pokemons.add(pokemon);
        this.probability.add(probability);
    }

    public String getMapName() {
        return mapName;
    }

    public int getMapId() {
        return mapId;
    }

    public ArrayList<Long> getProbability() {
        return probability;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pmap pmap = (Pmap) o;
        return this.getMapName().equals(pmap.getMapName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapName, mapId, pokemons, probability);
    }

    @Override
    public String toString() {
        return "Map{" +
                "mapName='" + mapName + '\'' +
                ", mapId=" + mapId +
                ", pokemons=" + pokemons +
                ", probability=" + probability +
                '}';
    }
}
