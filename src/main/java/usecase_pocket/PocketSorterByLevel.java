package usecase_pocket;

import entity.Pocket;
import entity.Pokemon;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PocketSorterByLevel implements IPocketSorter {

    /**
     * sort pocket by level
     * @param pocket the container of pokemons of player
     */
    @Override
    public void sort(Pocket pocket) {
        List<Pokemon> pokemons = pocket.getPokemons();
        pokemons.sort(new LevelComparator());
        Collections.reverse(pokemons);
    }

    private static class LevelComparator implements Comparator<Pokemon> {
        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            int result = p1.getLevel() - p2.getLevel();
            if (result != 0) {
                return result;
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        }
    }
}