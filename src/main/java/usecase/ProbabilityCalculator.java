package usecase;

import java.util.List;
import java.util.Random;

public class ProbabilityCalculator {
    public int calculate(List<Integer> probabilities) {
        Random r = new Random();
        int i = r.nextInt(100);
        int sum = 0;
        int index = 0;
        for (int p : probabilities) {
            sum += p;
            if (sum > i) {
                return index;
            } else {
                index += 1;
            }
        }
        return -1;
    }
}
