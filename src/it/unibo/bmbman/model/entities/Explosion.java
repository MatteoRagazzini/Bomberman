package it.unibo.bmbman.model.entities;

import java.awt.Rectangle;

import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.TerrainFactoryImpl;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Create Explosion.
 *
 */
public class Explosion extends Pair<Rectangle, Rectangle> {
    /**
     * Explosion is a pair of rectangle, one horizontal and one vertical.
     * @param pos 
     * @param range 
     */
    public Explosion(final Position pos, final int range) {
        super(new Rectangle(pos.getX() - getShift(range) * TerrainFactoryImpl.CELL_DIMENSION, pos.getY(), 
                TerrainFactoryImpl.CELL_DIMENSION * range, TerrainFactoryImpl.CELL_DIMENSION),
                new Rectangle(pos.getX(), pos.getY() - getShift(range) * TerrainFactoryImpl.CELL_DIMENSION, 
                        TerrainFactoryImpl.CELL_DIMENSION, TerrainFactoryImpl.CELL_DIMENSION * range));
    }
    /**
     * Get how many cells have to be considerated around the center of explosion. 
     * @return number of cells
     */
    private static int getShift(final int range) {
        return range == 3 ? 1 : 2;
    }
}
