package usecase_battle;

public class HealCalculator {
    /**
     * calculate the healing by the max hp of a pokemon
     * @param maxHitPoint the max hit point of a pokemon
     * @return the heal point
     */
    public int calculate(int maxHitPoint) {
        return maxHitPoint / 5;
    }
}