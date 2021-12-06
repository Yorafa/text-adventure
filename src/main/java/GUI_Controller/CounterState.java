package GUI_Controller;

import entity.Pokemon;
import entity.PokemonType;

public class CounterState {

    public static boolean IsCounter(Pokemon p1, Pokemon p2) {
        switch (p1.getPokemonType()){
            case ELECTRICITY:
                return true;

            case FIRE:
                return p2.getPokemonType() == PokemonType.GRASS;
            case WATER:
                return p2.getPokemonType() == PokemonType.FIRE;
            case GRASS:
                return p2.getPokemonType() == PokemonType.WATER;
            default:
                return false;
        }
    }
}
