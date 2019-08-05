package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Class used to model the beaviour of a wall.
 */
public class Wall extends AbstractEntity {
    /**
     * Create a wall.
     * @param position start position of the monster
     * @param entityType type of the entity
     * @param dimension dimension2D of the monster
     */
    public Wall(final Position position, final EntityType entityType, final Dimension dimension) {
        super(position, entityType, dimension);
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
    }

    @Override
    public void update() {
    }

    @Override
    protected void reachedBorder() {
    }
}
