package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Model a bonus bomb number power-up.
 */
public class BonusBombNum extends AbstractPowerupEntity {
    /**
     * Construct a bonus bomb number power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public BonusBombNum(final Position position) {
        super(position, true);
    }
    /**
     * {@inheritDoc}}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        Bomb.incrementBombsNumber();
    }
    @Override
    public void removeEffect(Hero hero) {     
    }
}
