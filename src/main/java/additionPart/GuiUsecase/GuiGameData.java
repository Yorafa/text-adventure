package additionPart.GuiUsecase;

import java.io.Serializable;
import java.util.Date;

public class GuiGameData implements Serializable {
    private final GuiPlayerPokemons playerPokemons;
    private final TextAdventureMap currentPlace;
    private final Date date;

    /**
     * Construct a GuiGameData, given them the given playerPokemons and currentPlace
     * @param playerPokemons all pokemons of player
     * @param currentPlace the current place player in
     *
     * @see GuiPlayerPokemons
     * @see TextAdventureMap
     */
    public GuiGameData(GuiPlayerPokemons playerPokemons, TextAdventureMap currentPlace) {
        this.playerPokemons = playerPokemons;
        this.currentPlace = currentPlace;
        this.date = new Date();
    }

    public GuiGameData(){
        this.playerPokemons = new GuiPlayerPokemons();
        this.currentPlace = null;
        this.date = new Date();
    }

    public GuiPlayerPokemons getPlayerPokemons() {
        return playerPokemons;
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
