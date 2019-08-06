package it.unibo.bmbman.model;


import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Class used to model the beaviour of a tile.
 *
 */
public class Tile extends AbstractEntity {
/**
 * crate a tile.
 * @param position position of the tile  
 * @param dimension dimension of the tile
 */
    public Tile(final Position position, final Dimension dimension) {
        super(position, EntityType.TILE, dimension);
    }

    @Override
    protected void reachedBorder() {
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
    }

    @Override
    public void update() {
    }

}
