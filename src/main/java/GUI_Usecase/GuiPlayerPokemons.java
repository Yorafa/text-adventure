package GUI_Usecase;

import GUI_Interface.PokemonIterableCollection;
import GUI_Interface.PokemonIterator;
import entity.Pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiPlayerPokemons implements Serializable, PokemonIterableCollection {
    private List<Pokemon> pocketPokemons;
    private List<Pokemon> libraryPokemons;

    public GuiPlayerPokemons() {
        pocketPokemons = new ArrayList<>();
        libraryPokemons = new ArrayList<>();}

    public List<Pokemon> getLibraryPokemons() {
        return libraryPokemons;
    }

    public List<Pokemon> getPocketPokemons() {
        return pocketPokemons;
    }

    public int getLibrarySize(){
        return libraryPokemons.size();
    }

    public int getPocketSize(){
        return pocketPokemons.size();
    }

    public int indexOfLibraryPokemon(Pokemon pokemon)
    {
        return pocketPokemons.indexOf(pokemon);
    }

    public Pokemon getLibraryPokemon(int index){
        return libraryPokemons.get(index);
    }

    public Pokemon getPocketPokemon(int index){
        return pocketPokemons.get(index);
    }

    public void setPocketPokemons(List<Pokemon> pocketPokemons) {
        this.pocketPokemons = pocketPokemons;
    }

    public void setLibraryPokemons(List<Pokemon> libraryPokemons) {
        this.libraryPokemons = libraryPokemons;
    }

    public void addPocketPokemon(Pokemon pokemon){
        pocketPokemons.add(pokemon);
    }

    public void addLibraryPokemon(Pokemon pokemon){
        libraryPokemons.add(pokemon);
    }

    public void addPocketPokemon(int index, Pokemon pokemon){
        pocketPokemons.add(index, pokemon);
    }

    public void addLibraryPokemon(int index,Pokemon pokemon){
        libraryPokemons.add(index, pokemon);
    }

    public void removePocketPokemon(int index){
        pocketPokemons.remove(index);
    }

    public void removePocketPokemon(Pokemon pokemon){
        pocketPokemons.remove(pokemon);
    }

    public void removeLibraryPokemon(int index){
        libraryPokemons.remove(index);
    }

    public void removeLibraryPokemon(Pokemon pokemon){
        libraryPokemons.remove(pokemon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuiPlayerPokemons that = (GuiPlayerPokemons) o;
        return getPocketPokemons().equals(that.getPocketPokemons()) && getLibraryPokemons().equals(that.getLibraryPokemons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPocketPokemons(), getLibraryPokemons());
    }

    @Override
    public PokemonIterator createPocketIterator() {
        return new GuiPocketIterator(this);
    }

    @Override
    public PokemonIterator createLibraryIterator() {
        return new GuiLibraryIterator(this);
    }

}