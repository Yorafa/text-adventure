package usecase_pokemon;

public class LevelCalculator {
    /**
     * method calculate the level of pokemon
     *
     * @param experiencePoint pokemon's exp
     * @return the level of pokemon
     */
    public int calculateLevel(int experiencePoint) {
        return (int) Math.round(Math.sqrt(experiencePoint));
    }

    /**
     * method calculate the exp of pokemon
     *
     * @param level pokemon's level
     * @return the exp of pokemon
     */
    public int calculateExperiencePoint(int level) {
        return (int) Math.pow(level, 2);
    }
}