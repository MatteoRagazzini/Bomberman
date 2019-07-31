package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;
/**
 * Models the general aspects of a lifeless entity.
 *
 */
public abstract class AbstractEntity implements Entity {

    private Point position;
    private boolean solidity;
    private final EntityType entityType;
    private final Dimension dimension;
    private final CollisionComponent collisionComponent;
    /**
     * Create a static entity.
     * @param position the point in the game world
     * @param solidity if the entity is solid
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractEntity(final Point position, final boolean solidity, final EntityType entityType, final Dimension dimension) {
        this.position = position;
        this.solidity = solidity;
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
        this.position = position;
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
    public boolean isSolid() {
        return this.solidity;
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
