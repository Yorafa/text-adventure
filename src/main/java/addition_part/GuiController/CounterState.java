package addition_part.GuiController;

import entity.Pokemon;
import entity.PokemonType;

public class CounterState {
    /**
     * GRASS counter WATER
     * WATER counter FIRE
     * FIRE counter GRASS
     * (GRASS || WATER || FIRE) and ELECTRICITY counter each other
     *
     * @see PokemonType
     */

    public static boolean IsCounter(Pokemon p1, Pokemon p2) {
        switch (p1.getPokemonType()) {
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
