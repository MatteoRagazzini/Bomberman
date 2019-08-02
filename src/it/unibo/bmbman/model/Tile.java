package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;
/**
 * 
 *
 */
public class Tile extends AbstractEntity {
/**
 * 
 * @param position 
 * @param dimension 
 */
    public Tile(final Point position, final Dimension dimension) {
        super(position, EntityType.TILE, dimension);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void reachedBorder() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCollision(final Entity receiver, final Point newPosition) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

}
