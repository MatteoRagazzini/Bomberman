package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Class used to model the behavior of a tile.
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Collision c) {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove() {
        return false;
    }


}

