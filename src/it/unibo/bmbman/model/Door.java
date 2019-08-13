package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Position;
/**
 * Model the door to reach to win the game.
 */
public class Door extends AbstractPowerupEntity {
    /**
     * Construct the door in the world.
     * @param position where to create it.
     * @param dimension the dimension of the door.
     */
    public Door() {
        super(Terrain.DOOR_POSITION, true);
    }

    @Override
    public final void powerupEffect(final Hero hero) {
        hero.win();
    }

}
