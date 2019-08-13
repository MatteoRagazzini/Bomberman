package it.unibo.bmbman.model;
/**
 *
 */
public class LevelImpl implements Level {
    private static final int BLOCKS_FOR_LEVEL = 100;
    private static final int MONSTER_FOR_LEVEL = 2;
    private static final int ONE_TYPE_BONUS_FOR_LEVEL = 2;
    private static final int ONE_TYPE_MALUS_FOR_LEVEL = 1;
    private int level;
    private int monstersNumber;
    private int blocksNumber;
    private int malusFreezeNumber;
    private int malusInvertNumber;
    private int malusLifeNumber;
    private int malusSlowNumber;
    private int bonusBombNumber;
    private int bonusRangeNumber;
    private int bonusLifeNumber;
    private int bonusVelocityNumber;
    /**
     * 
     */
    public LevelImpl() {
        this.level = 3;
        this.setAll();
    }
    private void setAll() {
        this.monstersNumber = level * MONSTER_FOR_LEVEL;
        this.blocksNumber = level * BLOCKS_FOR_LEVEL;
        this.malusFreezeNumber = level * ONE_TYPE_MALUS_FOR_LEVEL;
        this.malusInvertNumber = level * ONE_TYPE_MALUS_FOR_LEVEL;
        this.malusLifeNumber = level * ONE_TYPE_MALUS_FOR_LEVEL;
        this.malusSlowNumber = level * ONE_TYPE_MALUS_FOR_LEVEL;
        this.bonusBombNumber = level * ONE_TYPE_BONUS_FOR_LEVEL;
        this.bonusLifeNumber = level * ONE_TYPE_BONUS_FOR_LEVEL;
        this.bonusRangeNumber = level * ONE_TYPE_BONUS_FOR_LEVEL;
        this.bonusVelocityNumber = level * ONE_TYPE_BONUS_FOR_LEVEL;
    }
    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void levelUp() {
        this.level = level + 1;
        this.setAll();
    }

    @Override
    public void setLevelOne() {
        this.level = 1;
        this.setAll();
    }

    @Override
    public int getBlocksNumber() {

        return this.blocksNumber;
    }

    @Override
    public int getMonsterNumber() {
        return this.monstersNumber;
    }

    @Override
    public int getMalusFreezeNumber() {

        return this.malusFreezeNumber;
    }

    @Override
    public int getMalusInvertNumber() {

        return this.malusInvertNumber;
    }

    @Override
    public int getMalusLifeNumber() {

        return this.malusLifeNumber;
    }

    @Override
    public int getMalusSlowNumber() {

        return this.malusSlowNumber;
    }

    @Override
    public int getBonusBombNumber() {

        return this.bonusBombNumber;
    }

    @Override
    public int getBonusRangeNumber() {

        return this.bonusRangeNumber;
    }

    @Override
    public int getBonusLifeNumber() {

        return this.bonusLifeNumber;
    }

    @Override
    public int getBonusVelocityNumber() {

        return this.bonusVelocityNumber;
    }

}
