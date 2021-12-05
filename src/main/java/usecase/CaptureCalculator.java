package usecase;

import java.util.Random;

public class CaptureCalculator {
    public boolean calculate(int hitPoint, int maxHitPoint) {
        Random r = new Random();
        return r.nextDouble() > 0.8 * hitPoint / maxHitPoint + 0.1;
    }
}
