package addition_part.GuiInterface;

import entity.Pokemon;

public interface PokemonIterator {
    boolean hasNext();

    Pokemon getNext();

    void reset();
}
