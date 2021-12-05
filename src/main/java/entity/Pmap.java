package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    //    public Pmap(){
//        this.mapName = "";
//        this.pokemons = new ArrayList<>();
//    }

//    public Pmap(String mapName){
//        this.mapName = mapName;
//        this.pokemons = new ArrayList<>();
//    }

//    public void setMapName(String mapName) {
//        this.mapName = mapName;
//    }
//
//    public void setPokemons(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }

//    public List<Pokemon> getPokemons() {
//        return pokemons;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pmap pmap = (Pmap) o;
//        return this.getMapName().equals(pmap.getMapName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(mapName, pokemons);
//    }
//
//    @Override
//    public String toString() {
//        return "Map{" +
//                "mapName='" + mapName + '\'' +
//                ", pokemons=" + pokemons +
//                '}';
//    }
}
