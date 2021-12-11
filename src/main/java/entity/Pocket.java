package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * container store pokemons that player has
 */
public class Pocket implements Serializable, Iterable<Pokemon> {
    private final List<Pokemon> pokemons;
    private Pokemon battlePokemon;

    /**
     * Construct Pocket as it contains an empty list
     */
    public Pocket() {
        pokemons = new ArrayList<>();
    }

    /**
     * the getter method of battlePokemon
     *
     * @return the pokemon that will use to battle
     */
    public Pokemon getBattlePokemon() {
        return battlePokemon;
    }

    /**
     * the getter method of battlePokemon
     *
     * @param battlePokemon the pokemon player want to set as the battle pokemon
     */
    public void setBattlePokemon(Pokemon battlePokemon) {
        this.battlePokemon = battlePokemon;
    }

    /**
     * set the pokemon the beginning of pokemons
     *
     * @param battlePokemon the pokemon on the first order
     */
    public void setFirstPokemon(Pokemon battlePokemon) {
        pokemons.remove(battlePokemon);
        pokemons.add(0, battlePokemon);
    }

    /**
     * the adder method, add pokemon into player's pocket
     *
     * @param pokemon the pokemon player capture
     */
    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    /**
     * the getter method of pokemons
     *
     * @return all pokemons that player has
     */
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Pokemon> iterator() {
        return pokemons.iterator();
    }

    /**
     * the size method
     *
     * @return the length of the list pokemons
     */
    public int size() {
        return pokemons.size();
    }

    /**
     * the get method that get from list pokemons
     *
     * @param i the given index
     * @return the pokemon at the index of list pokemons
     */
    public Pokemon get(int i) {
        return pokemons.get(i);
    }
}