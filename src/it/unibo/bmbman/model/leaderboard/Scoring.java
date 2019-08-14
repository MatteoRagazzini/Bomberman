package it.unibo.bmbman.model.leaderboard;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ISUB;

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
        //LIFE_REMOVED (-200),
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
     * @param e 
     * @return point
     */
    public static int getPoint(final Entity e) {
        if (e.getType() == EntityType.POWER_UP) {
            final AbstractPowerupEntity en = (AbstractPowerupEntity) e;
            return en.isBonus() ? BONUS.value : MALUS.value;
        } else if (e.getType().equals(EntityType.MONSTER)) {
            return MONSTER.value;
        }
        return 0;
    }
}
