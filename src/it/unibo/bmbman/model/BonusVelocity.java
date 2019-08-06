package it.unibo.bmbman.model;

import java.util.concurrent.TimeUnit;

import it.unibo.bmbman.controller.GameController;
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
    public BonusVelocity(final Position position, final Dimension dimension, final GameController gc) {
        super(position, dimension);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected void reachedBorder() {
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
    public void update() {
    }

}
