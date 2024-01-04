package usecase_pokemon;

public class LeveledDataCalculator {
    /**
     * method calculate the new data calculate by level and base data
     *
     * @param basePoint the base data
     * @param level     the new level
     * @return the updated data
     */
    public int calculate(int basePoint, int level) {
        return (int) Math.round((double) basePoint * (1.0 / 11.0 * level + 10.0 / 11.0));
    }
}
