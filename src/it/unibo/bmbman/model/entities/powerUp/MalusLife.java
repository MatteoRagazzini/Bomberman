package it.unibo.bmbman.model.entities.powerUp;

import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a malus life power-up.
 */
public class MalusLife extends AbstractPowerupEntity {
    /**
     * Construct a malus life power-up in the world.
     * @param position where to create it.
     */
    public MalusLife(final Position position) {
        super(position,  false);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.removeLife();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEffect(final Hero hero) {
    }

}
