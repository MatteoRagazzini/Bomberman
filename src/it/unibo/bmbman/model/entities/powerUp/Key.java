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
    public Key(final Position position) {
        super(position, true);
    }

    @Override
    public final void powerupEffect(final Hero hero) {
        System.out.println("PRESO CHIAVE");
        hero.setKeyFind();
    }

    @Override
    public void removeEffect(Hero hero) {    
    }

}
