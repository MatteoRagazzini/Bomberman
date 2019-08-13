package it.unibo.bmbman.model;

public interface Level {
    int getLevel();
    void levelUp();
    void setLevelOne();
    int getBlocksNumber();
    int getMonsterNumber();
    int getMalusFreezeNumber();
    int getMalusInvertNumber();
    int getMalusLifeNumber();
    int getMalusSlowNumber();
    int getBonusBombNumber();
    int getBonusRangeNumber();
    int getBonusLifeNumber();
    int getBonusVelocityNumber();
}
