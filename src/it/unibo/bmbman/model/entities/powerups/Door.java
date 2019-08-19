package it.unibo.bmbman.model.entities.powerups;

import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.TerrainFactoryImpl;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.utilities.Dimension;
/**
 * Model the door to reach to win the game.
 */
public class Door extends AbstractPowerupEntity {
    /**
     * Construct the door in the world.
     */
    public Door() {
        super(TerrainFactoryImpl.DOOR_POSITION, new Dimension(TerrainFactoryImpl.CELL_DIMENSION, TerrainFactoryImpl.CELL_DIMENSION), true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void powerupEffect(final HeroImpl hero) {
        hero.checkWin();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove() {
        return false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEffect(final HeroImpl hero) {
    }

}
