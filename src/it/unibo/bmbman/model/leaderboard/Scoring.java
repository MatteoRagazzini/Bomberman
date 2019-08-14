package it.unibo.bmbman.model.leaderboard;

import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.powerUp.AbstractPowerupEntity;
import it.unibo.bmbman.model.utilities.EntityType;

/**
 *
 */
public enum Scoring {
        BONUS(50),
        MALUS(-50),
        MONSTER(100),
        DOOR(200);

    private final int value;
    /**
     * 
     * @param value 
     */
    Scoring(final int value) {
        this.value = value;
    }
    /**
     * 
     * @param entity
     * @return zero if the entity isn't a power up or monster, otherwise the {@link Scoring} value
     */
    public static int getPoint(final Entity entity) {
        if (entity.getType() == EntityType.POWER_UP) {
            final AbstractPowerupEntity powerUp = (AbstractPowerupEntity) entity;
            return powerUp.isBonus() ? BONUS.value : MALUS.value;
        } else if (entity.getType().equals(EntityType.MONSTER)) {
            return MONSTER.value;
        }
        return 0;
    }
}
