package usecase;

import entity.Pokemon;

public class ExperiencePointCalculator {
    public int calculate(Pokemon pokemon) {
        return pokemon.getExperiencePoint() / 5;
    }
}