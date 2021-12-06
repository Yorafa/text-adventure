package usecase_battle;

public interface BattleAction {
    void attack();

    void defense();

    void heal();

    boolean capture();
}
