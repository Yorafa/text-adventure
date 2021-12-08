package usecase_pokemon;

import entity.Pokemon;

public class ExperiencePointCalculator {
    /**
     * method calcualte how much exp
     * @param pokemon pokemon
     * @return poekmon current exp / 5
     */
    public int calculate(Pokemon pokemon) {
        return pokemon.getExperiencePoint() / 5;
    }
}