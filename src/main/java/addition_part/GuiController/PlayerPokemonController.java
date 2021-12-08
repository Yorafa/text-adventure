package addition_part.GuiController;

import addition_part.GuiUsecase.GuiPlayerPokemons;
import entity.Pokemon;

import java.util.List;

public class PlayerPokemonController {
    private GuiPlayerPokemons playerPokemons;

    /**
     * Construct a PlayerPokemonController, given them the playerPokemons
     *
     * @param playerPokemons all pokemons that player has
     * @see GuiPlayerPokemons
     */
    public PlayerPokemonController(GuiPlayerPokemons playerPokemons) {
        this.playerPokemons = playerPokemons;
    }

    public GuiPlayerPokemons getPlayerPokemons() {
        return playerPokemons;
    }

    public void setPlayerPokemons(GuiPlayerPokemons playerPokemons) {
        this.playerPokemons = playerPokemons;
    }

    public List<Pokemon> getPocketPokemons() {
        return playerPokemons.getPocketPokemons();
    }

    public List<Pokemon> getLibraryPokemons() {
        return playerPokemons.getLibraryPokemons();
    }

    public boolean intoLib(Pokemon pokemon) {
        if (playerPokemons.getPocketSize() > 1) {
            playerPokemons.removePocketPokemon(pokemon);
            playerPokemons.addLibraryPokemon(pokemon);
            return true;
        }
        return false;
    }

    public boolean addPocketPokemon(Pokemon pokemon) {
        if (playerPokemons.getPocketSize() < 6) {
            playerPokemons.addPocketPokemon(pokemon);
            return true;
        } else {
            addLibraryPokemon(pokemon);
            return false;
        }
    }

    public boolean moveIntoPocket(Pokemon pokemon) {
        if (playerPokemons.getPocketSize() < 6) {
            playerPokemons.addPocketPokemon(pokemon);
            playerPokemons.removeLibraryPokemon(pokemon);
            return true;
        } else {
            return false;
        }
    }

    public void addLibraryPokemon(Pokemon pokemon) {
        playerPokemons.addLibraryPokemon(pokemon);
    }

    public void setFirstPokemon(Pokemon pokemon) {
        playerPokemons.removePocketPokemon(pokemon);
        playerPokemons.addPocketPokemon(0, pokemon);
    }
}
