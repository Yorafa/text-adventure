package usecase_battle;

import java.util.Random;

public class CaptureCalculator {
    /**
     * @param hitPoint the HP of one pokemon
     * @param maxHitPoint the Max HP of the same pokemon
     * @return true/false represent if pokemon can capture
     */
    public boolean calculate(int hitPoint, int maxHitPoint) {
        Random r = new Random();
        return r.nextDouble() > 0.8 * hitPoint / maxHitPoint + 0.1;
    }
}