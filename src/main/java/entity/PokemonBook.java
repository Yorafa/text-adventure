package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The container of base pokemon
 */
public class PokemonBook implements Serializable {
    private final List<BasePokemon> pokemonBook;

    /**
     * Construct a PokemonBook give them a new arraylist
     * <p>
     * The relative classes
     *
     * @see BasePokemon
     */
    public PokemonBook() {
        this.pokemonBook = new ArrayList<>();
    }

    /**
     * add base pokemon into pokekmonBook
     *
     * @param pokemon the base pokemon
     */
    public void addPokemon(BasePokemon pokemon) {
        pokemonBook.add(pokemon);
    }

    /**
     * remove the index position pokemon from pokemonBook
     *
     * @param i the index i
     */
    public void removePokemon(int i) {
        pokemonBook.remove(i);
    }

    /**
     * the getter method of pokemonBook
     *
     * @return the pokemon book
     */
    public List<BasePokemon> getPokemonBook() {
        return pokemonBook;
    }

    /**
     * @param i integer index
     * @return the base pokemon at index of pokemon book
     */
    public BasePokemon get(int i) {
        return pokemonBook.get(i);
    }

    /**
     * @param name the name of pokemon
     * @return the pokemon has the given name in the pokemon book
     */
    public BasePokemon get(String name) {
        for (BasePokemon basePokemon : pokemonBook) {
            if (basePokemon.getName().equals(name)) {
                return basePokemon;
            }
        }
        return null;
    }
}
