package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;

import it.unibo.bmbman.view.MyGUIFactory;
/**
 * Models the general aspects of a lifeless entity.
 *
 */
public abstract class AbstractEntity implements Entity {

    private Point position;
    private final EntityType entityType;
    private final Dimension dimension;
    private final CollisionComponent collisionComponent;
    /**
     * Create a static entity.
     * @param position the point in the game world
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractEntity(final Point position, final EntityType entityType, final Dimension dimension) {
        this.position = position;
        this.entityType = entityType;
        this.dimension = dimension;
        this.collisionComponent = new CollisionComponentImpl(this);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Point getPosition() {
        return position;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Point position) {
        this.position.x = position.x <= 0 ? 0 
                : position.x >= MyGUIFactory.FRAME_WIDTH - this.dimension.width ? MyGUIFactory.FRAME_WIDTH - this.dimension.width : position.x;
        this.position.y = position.y <= 0 ? 0 
                : position.y >= MyGUIFactory.FRAME_HEIGHT - this.dimension.height ? MyGUIFactory.FRAME_HEIGHT  - this.dimension.height : position.y;
        if (position.x <= 0 || position.x >= MyGUIFactory.FRAME_WIDTH - this.dimension.width || position.y <= 0 || position.y >= MyGUIFactory.FRAME_HEIGHT - this.dimension.height) {
            reachedBorder();
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void remove() {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getDimension() {
        return this.dimension;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getType() {
        return this.entityType;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public CollisionComponent getCollisionComponent() {
        return this.collisionComponent;
    }
    /**
     * Used to notify entity that reach the border.
     */
    protected abstract void reachedBorder();
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void onCollision(Entity receiver, Point newPosition);
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void update();
}
