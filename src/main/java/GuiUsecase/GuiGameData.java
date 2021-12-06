package GuiUsecase;

import java.io.Serializable;
import java.util.Date;

public class GuiGameData implements Serializable {
    private GuiPlayerPokemons playerPokemons;
    private TextAdventureMap currentPlace;
    private Date date;

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

    public void setPlayerPokemons(GuiPlayerPokemons playerPokemons) {
        this.playerPokemons = playerPokemons;
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(TextAdventureMap currentPlace) {
        this.currentPlace = currentPlace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
