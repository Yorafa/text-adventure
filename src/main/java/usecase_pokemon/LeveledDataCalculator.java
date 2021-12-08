package usecase_pokemon;

public class LeveledDataCalculator {
    public int calculate(int basePoint, int level) {
        return (int) Math.round((double) basePoint * (1.0 / 11.0 * level + 10.0 / 11.0));
    }
}
