package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;

import it.unibo.bmbman.model.utilities.Velocity;

/**
 * Models the general aspects of a living entity.
 *
 */
public abstract class AbstractLivingEntity extends AbstractEntity implements LivingEntity {
    private int lives;
    private Velocity velocity;
    private Direction direction;
    /**
     * Create an {@link AbstractLivingEntity}.
     * @param position where the entity is in the world
     * @param solidity .
     * @param entityType the {@link EntityType} of this entity
     * @param dimension the {@link Dimension} of entity
     * @param lives the number of lives that the entity has
     */
    public AbstractLivingEntity(final Point position, final boolean solidity, final EntityType entityType, final Dimension dimension, final int lives) {
        super(position, solidity, entityType, dimension);
        this.lives = lives;
<<<<<<< HEAD
        this.solidity = solidity;
        this.entityType = entityType;
        this.dimension = dimension;
        this.velocity = new Velocity(0, 0);
    }
    /**
     * 
     */
    @Override
    public void setPosition(final Point2D position) {
        this.position = position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point2D getPosition() {
        return position;
    }
    @Override
    public void remove() {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle2D getDimension() {
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
=======
        this.direction = Direction.IDLE;
        this.velocity = Velocity.ZERO;
>>>>>>> testCollider
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlive() {
        return this.lives > 0;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addLife() {
        this.lives = this.lives + 1;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLife() {
        this.lives = this.lives - 1 > 0 ? this.lives - 1 : 0; 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLives() {
        return this.lives;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void move() {
        switch (getDirection()) {
        case IDLE:
            setVelocity(Velocity.ZERO);
            break;
        case UP:
            setVelocity(new Velocity(0, -Velocity.SPEED));
            break;
        case DOWN:
            setVelocity(new Velocity(0, Velocity.SPEED));
            break;
        case LEFT:
            setVelocity(new Velocity(-Velocity.SPEED, 0));
            break;
        case RIGHT:
            setVelocity(new Velocity(Velocity.SPEED, 0));
            break;
        default:
            break;
        }
        update();
    }
    /**
     * {@inheritDoc}
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * {@inheritDoc}
     */
    public void setVelocity(final Velocity velocity) {
        this.velocity = velocity;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getDirection() {
        return this.direction;
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
    public void update() {
        this.getPosition().translate(this.getVelocity().getXcomponent(), this.getVelocity().getYcomponent());
    }

}
