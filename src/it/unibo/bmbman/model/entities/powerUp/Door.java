package it.unibo.bmbman.model.entities.powerUp;


import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Dimension;
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
        super(Terrain.DOOR_POSITION, new Dimension(Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION),true);
    }

    @Override
    public final void powerupEffect(final Hero hero) {
        hero.checkWin();
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public void removeEffect(Hero hero) {   
    }

}
