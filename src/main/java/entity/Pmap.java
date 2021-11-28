package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pmap implements Serializable {
    private String mapName;
    private List<Pokemon> pokemons;
    private List<Double> probability;
    // Note: the two Lists are parallel so that easy catch up.

    public Pmap(){
        this.mapName = "";
        this.pokemons = new ArrayList<>();
        this.probability = new ArrayList<>();
    }

    public Pmap(String mapName, int mapId){
        this.mapName = mapName;
        this.pokemons = new ArrayList<>();
        this.probability = new ArrayList<>();
    }


    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setProbability(List<Double> probability) {
        this.probability = probability;
    }

    public String getMapName() {
        return mapName;
    }


    public List<Double> getProbability() {
        return probability;
    }

    public List<Pokemon> getPokemons() {
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
        return Objects.hash(mapName, pokemons, probability);
    }

    @Override
    public String toString() {
        return "Map{" +
                "mapName='" + mapName + '\'' +
                ", pokemons=" + pokemons +
                ", probability=" + probability +
                '}';
    }
}
