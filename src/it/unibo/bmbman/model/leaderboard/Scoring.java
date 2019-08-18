package it.unibo.bmbman.model.leaderboard;

import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.powerups.AbstractPowerupEntity;
import it.unibo.bmbman.model.utilities.EntityType;

/**
 *
 */
public enum Scoring {
        /**
         * bonus's score.
         */
        BONUS(50),
        /**
         * malus's score.
         */
        MALUS(-50),
        /**
         * monster killed's score.
         */
        MONSTER(100);

    private int value;
    /**
     * 
     * @param value 
     */
    Scoring(final int value) {
        this.value = value;
    }
    /**
     * 
     * @return value
     */
    public int getValue() {
        return value;
    }
    /**
     * 
     * @param entity 
     * @return scoring 
     */
    public static int getPoint(final Entity entity) {
        if (entity.getType() == EntityType.POWER_UP) {
            final AbstractPowerupEntity powerUp = (AbstractPowerupEntity) entity;
            return powerUp.isBonus() ? BONUS.getValue() : MALUS.getValue();
        } else if (entity.getType().equals(EntityType.MONSTER)) {
            return MONSTER.getValue();
        }
        return 0;
    }
}
