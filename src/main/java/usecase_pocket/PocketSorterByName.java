package usecase_pocket;

import entity.Pocket;
import entity.Pokemon;

import java.util.Comparator;
import java.util.List;

public class PocketSorterByName implements IPocketSorter {
    @Override
    public void sort(Pocket pocket) {
        List<Pokemon> pokemons = pocket.getPokemons();
        pokemons.sort(new NameComparator());
    }

    private static class NameComparator implements Comparator<Pokemon> {
        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            int result = p1.getName().compareTo(p2.getName());
            if (result != 0) {
                return result;
            } else {
                return p1.getLevel() - p2.getLevel();
            }
        }
    }
}
