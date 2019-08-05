package it.unibo.bmbman.model;


import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
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
    public Tile(final Position position, final Dimension dimension) {
        super(position, EntityType.TILE, dimension);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void reachedBorder() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

}
