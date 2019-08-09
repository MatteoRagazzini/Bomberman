package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a bonus life power-up.
 */
public class BonusLife extends AbstractPowerupEntity {
    /**
     * Construct a bonus life power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public BonusLife(final Position position, final Dimension dimension) {
        super(position, dimension, true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.addLife();
    }
}
