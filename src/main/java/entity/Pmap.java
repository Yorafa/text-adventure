package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pmap implements Serializable {
    private String mapName;
    private List<List<String>> pokemons;
    private final int MIN_ExperiencePoint;
    private final int MAX_ExperiencePoint;
    // Note: the two Lists are parallel so that easy catch up.

    public Pmap(){
        this.mapName = "";
        this.pokemons = new ArrayList<>();
        this.MIN_ExperiencePoint = 0;
        this.MAX_ExperiencePoint = 0;
    }

    public int getMAX_ExperiencePoint() {
        return MAX_ExperiencePoint;
    }

    public int getMIN_ExperiencePoint() {
        return MIN_ExperiencePoint;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setPokemons(List<List<String>> pokemons) {
        this.pokemons = pokemons;
    }

    public String getMapName() {
        return mapName;
    }

    public List<List<String>> getPokemons() {
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
        return Objects.hash(mapName, pokemons);
    }

    @Override
    public String toString() {
        return "Map{" +
                "mapName='" + mapName + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
