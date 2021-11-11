package usecase;

import entity.*;


import java.util.ArrayList;

public class MapManager {
    private ArrayList<Map> maps;
    private Map map;

    public MapManager(){
        this.maps = new ArrayList<>();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMap(int index) {
        this.map = this.maps.get(index);
    }
}
