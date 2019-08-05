package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Models the general aspects of a power-up entity.
 */
public abstract class AbstractPowerupEntity extends AbstractEntity {
    private static EntityType entityType = EntityType.POWER_UP;
    /**
     * Constructor for a general power-up.
     * @param position the position where i want to locate the power-up
     * @param dimension the dimension of the power-up
     */
    public AbstractPowerupEntity(final Position position, final Dimension dimension) {
        super(position, entityType, dimension);
    }
    /**
     * After a collision with the hero, activate the power-up effect.
     */
    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        if (receiver.getType() == EntityType.HERO) {
            powerupEffect((Hero) receiver);
        }
    }
    /**
     * Active the effect.
     * @param hero the target of the effect.
     */
    public abstract void powerupEffect(Hero hero);
}
