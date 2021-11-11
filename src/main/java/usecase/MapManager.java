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
}
