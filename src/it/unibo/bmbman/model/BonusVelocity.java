package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a bonus velocity power-up.
 */
public class BonusVelocity extends AbstractPowerupEntity {
    /**
     * Construct a bonus velocity power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public BonusVelocity(final Position position, final Dimension dimension) {
        super(position, dimension, true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.setVelocityModifier(2.0);
    }
}
