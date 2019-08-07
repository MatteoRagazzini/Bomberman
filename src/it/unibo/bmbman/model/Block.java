package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
    /**
     *Class used to model the behavior of a block.
     *
     */
public class Block extends AbstractEntity {
    /**
     * crate a breakable wall.
     * @param position the block position
     * @param dimension the block dimension
     */
    public Block(final Position position, final Dimension dimension) {
       super(position, EntityType.BLOCK, dimension);
    }
    /**
     * {@inheritDoc}
     */
@Override
protected void reachedBorder() {
}
    /**
     * {@inheritDoc}
     */
@Override
public void onCollision(final Entity receiver, final Position newPosition) {
}
    /**
     * {@inheritDoc}
     */
@Override
public void update() {
}

}
