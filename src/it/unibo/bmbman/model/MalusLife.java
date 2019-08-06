package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a malus life power-up.
 */
public class MalusLife extends AbstractPowerupEntity {
    /**
     * Construct a malus life power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public MalusLife(final Position position, final Dimension dimension) {
        super(position, dimension);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.removeLife();
    }

}
