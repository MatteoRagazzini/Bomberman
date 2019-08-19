package it.unibo.bmbman.model.entities;


import it.unibo.bmbman.model.collision.Collision;
import it.unibo.bmbman.model.collision.CollisionComponent;
import it.unibo.bmbman.model.collision.CollisionComponentImpl;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Models the general aspects of a lifeless entity.
 *
 */
public abstract class AbstractEntity implements Entity {

    private  Position position;
    private final EntityType entityType;
    private final Dimension dimension;
    private final CollisionComponent collisionComponent;
    /**
     * Create a static entity.
     * @param position the point in the game world
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractEntity(final Position position, final EntityType entityType, final Dimension dimension) {
        this.position = position;
        this.entityType = entityType;
        this.dimension = dimension;
        this.collisionComponent = new CollisionComponentImpl(this);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Position getPosition() {
        return position;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Position position) {
        this.position = position;
    }
    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public abstract boolean remove();
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
    @Override
    public abstract void onCollision(Collision c);
}
