package it.unibo.bmbman.model;


import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.MyGUIFactory;
/**
 * Models the general aspects of a lifeless entity.
 *
 */
public abstract class AbstractEntity implements Entity {

    private final Position position;
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
        this.position.setX(position.getX() < 0 ? 0 
                : position.getX() > MyGUIFactory.FRAME_WIDTH - this.dimension.getWidth() ? MyGUIFactory.FRAME_WIDTH - this.dimension.getWidth() : position.getX());
        this.position.setY(position.getY() < 0 ? 0 
                : position.getY() > MyGUIFactory.FRAME_HEIGHT - this.dimension.getHeight() ? MyGUIFactory.FRAME_HEIGHT  - this.dimension.getHeight() : position.getY());
        if (position.getX() < 0 || position.getX() > MyGUIFactory.FRAME_WIDTH - this.dimension.getWidth() || position.getY() < 0 || position.getY() > MyGUIFactory.FRAME_HEIGHT - this.dimension.getHeight()) {
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
    public abstract void onCollision(Entity receiver, Position newPosition);
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void update();
}
