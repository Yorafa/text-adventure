package usecase_map;

import java.util.List;
import java.util.Random;

public class ProbabilityCalculator {

    /**
     * the probability of encounter wild pokemon
     * @param probabilities a list of integer represent probability
     * @return -1 represent nothing, of index of poekmon
     */
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
