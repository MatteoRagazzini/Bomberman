package it.unibo.bmbman.model.entities.powerUp;

import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a bonus velocity power-up.
 */
public class BonusVelocity extends AbstractPowerupEntity {
    /**
     * Construct a bonus velocity power-up in the world.
     * @param position where to create it.
     */
    public BonusVelocity(final Position position) {
        super(position,  true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.setVelocityModifier(2.0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEffect(final Hero hero) {
        hero.setVelocityModifier(1.0);
    }
}
