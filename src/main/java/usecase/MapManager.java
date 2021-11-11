package usecase;

import entity.*;

import java.util.ArrayList;

public class MapManager {
    private ArrayList<Pmap> pmaps;

    public MapManager(){this.pmaps = new ArrayList<>();}

    public ArrayList<Pmap> getMaps() {
        return pmaps;
    }

    public void addMap(Pmap pmap){
        pmaps.add(pmap);
    }

    public Pmap start(){
        return pmaps.get(0);
    }

    public Pmap find(String mapName){
        for (Pmap pmap: pmaps){
            if (pmap.getMapName().equals(mapName)){
                return pmap;
            }
        }
        return null;
    }
}
