package it.unibo.bmbman.model;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import it.unibo.bmbman.model.utilities.Velocity;
/**
 * Models the general aspects of a non living entity.
 *
 */
public abstract class AbstractStaticEntity implements Entity {
    private Point2D position;
    private boolean solidity;
    private EntityType entityType;
    private Rectangle2D dimension;
    /**
     * Create a static entity.
     * @param position the point in the game world
     * @param solidity if the entity is solid
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractStaticEntity(final Point2D position, final boolean solidity, final EntityType entityType, final Rectangle2D dimension) {
        this.position = position;
        this.solidity = solidity;
        this.entityType = entityType;
        this.dimension = dimension;
    }
    @Override
    public Point2D getPosition() {
        return position;
    }
    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }
    @Override
    public void remove() {
    }

    @Override
    public Rectangle2D getDimension() {
        return new Rectangle2D.Double(getPosition().getX(), getPosition().getY(), this.dimension.getWidth(), this.dimension.getHeight());
    }
    @Override
    public boolean isSolid() {
        return this.solidity;
    }
    @Override
    public EntityType getType() {
        return this.entityType;
    }
    @Override
    public abstract void onCollision(Entity receiver);
    
    @Override
    public abstract void update();
}
