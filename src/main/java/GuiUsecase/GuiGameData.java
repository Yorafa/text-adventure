package GuiUsecase;

import java.io.Serializable;

public class GuiGameData implements Serializable {
    private GuiPlayerPokemons playerPokemons;
    private TextAdventureMap currentPlace;

    public GuiGameData(GuiPlayerPokemons playerPokemons, TextAdventureMap currentPlace) {
        this.playerPokemons = playerPokemons;
        this.currentPlace = currentPlace;
    }

    public GuiGameData(){
        this.playerPokemons = new GuiPlayerPokemons();
        this.currentPlace = null;
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
}
