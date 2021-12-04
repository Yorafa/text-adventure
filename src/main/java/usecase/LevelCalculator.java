package usecase;

public class LevelCalculator {
    public int calculateLevel(int experiencePoint) {
        return (int) Math.round(Math.sqrt(experiencePoint));
    }
    public int calculateExperiencePoint(int level) {
        return (int) Math.pow(level, 2);
    }
}
