package it.unibo.bmbman.model;
/**
 * 
 * model the level in this game.
 */
public interface Level {
    /**
     * used to know the current level.
     * @return the current level
     */
    int getLevel();
    /**
     * used to increase the level.
     */
    void levelUp();
    /**
     * return to first level.
     */
    void setLevelOne();
    /**
     * says how many blocks are in this level.
     * @return the number of blocks 
     */
    int getBlocksNumber();
    /**
     * says how many monster are in this level.
     * @return the number of monsters
     */
    int getMonsterNumber();
    /**
     * says how many malus freeze are in this level.
     * @return the number of malus freeze
     */
    int getMalusFreezeNumber();
    /**
     * says how many malus invert are in this level.
     * @return the number of malus invert
     */
    int getMalusInvertNumber();
    /**
     * says how many malus life are in this level.
     * @return the number of malus life
     */
    int getMalusLifeNumber();
    /**
     * says how many malus slow are in this level.
     * @return the number of malus slow
     */
    int getMalusSlowNumber();
    /**
     * says how many bonus bomb are in this level.
     * @return the number of bonus bomb
     */
    int getBonusBombNumber();
    /**
     * says how many bonus bomb range are in this level.
     * @return the number of bonus bomb range
     */
    int getBonusRangeNumber();
    /**
     * says how many bonus life are in this level.
     * @return the number of bonus life
     */
    int getBonusLifeNumber();
    /**
     * says how many bonus velocity are in this level.
     * @return the number of bonus velocity
     */
    int getBonusVelocityNumber();
}
