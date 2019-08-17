package it.unibo.bmbman.model;
/**
 *
 */
public class LevelImpl implements Level {
    private static final int BLOCKS_FOR_LEVEL = 80;
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
        this.level = 1;
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
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel() {
        return this.level;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void levelUp() {
        this.level = level + 1;
        this.setAll();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevelOne() {
        this.level = 1;
        this.setAll();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBlocksNumber() {
        return this.blocksNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getMonsterNumber() {
        return this.monstersNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getMalusFreezeNumber() {
        return this.malusFreezeNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getMalusInvertNumber() {
        return this.malusInvertNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getMalusLifeNumber() {
        return this.malusLifeNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getMalusSlowNumber() {
        return this.malusSlowNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBonusBombNumber() {
        return this.bonusBombNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBonusRangeNumber() {
        return this.bonusRangeNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBonusLifeNumber() {
        return this.bonusLifeNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getBonusVelocityNumber() {
        return this.bonusVelocityNumber;
    }

}
