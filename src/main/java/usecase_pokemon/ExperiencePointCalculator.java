package usecase_pokemon;

import entity.Pokemon;

public class ExperiencePointCalculator {
    public int calculate(Pokemon pokemon) {
        return (int) (pokemon.getExperiencePoint() / 5.0);
    }
}