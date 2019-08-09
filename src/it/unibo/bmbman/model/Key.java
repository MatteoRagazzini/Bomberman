package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Model the key to find to finish the game.
 */
public class Key extends AbstractPowerupEntity {
    /**
     * Construct the key in the world.
     * @param position where to create it.
     * @param dimension the dimension of the key.
     */
    public Key(final Position position, final Dimension dimension) {
        super(position, dimension, true);
    }

    @Override
    public final void powerupEffect(final Hero hero) {
        hero.setKeyFind();
    }

}
