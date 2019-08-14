package it.unibo.bmbman.model.entities.powerUp;

import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Model a malus invert power-up.
 */
public class MalusInvert extends AbstractPowerupEntity {
    /**
     * Construct a malus invert power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public MalusInvert(final Position position) {
        super(position,  false);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        hero.setVelocityModifier(-1.0);
    }
    @Override
    public void removeEffect(Hero hero) {
        hero.setVelocityModifier(1.0);
        
    }
}