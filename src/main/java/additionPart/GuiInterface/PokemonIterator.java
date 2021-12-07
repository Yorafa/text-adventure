package additionPart.GuiInterface;

import entity.Pokemon;

public interface PokemonIterator {
    boolean hasNext();

    Pokemon getNext();

    void reset();
}
