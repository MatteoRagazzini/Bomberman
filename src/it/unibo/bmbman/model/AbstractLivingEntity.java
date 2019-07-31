package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;

import it.unibo.bmbman.model.utilities.Velocity;

/**
 * Models the general aspects of a living entity.
 *
 */
public abstract class AbstractLivingEntity implements LivingEntity, Entity {
    private Point position;
    private int lives;
    private boolean solidity;
    private EntityType entityType;
    private Dimension dimension;
    private Velocity velocity;
    private Direction direction;
    /**
     * Create a living entity.
     * @param position the point in the game world
     * @param lives how many lives the entity has.
     * @param solidity if the entity is solid
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractLivingEntity(final Point position, final int lives, final boolean solidity, 
            final EntityType entityType, final Dimension dimension) {
        this.position = position;
        this.lives = lives;
        this.solidity = solidity;
        this.entityType = entityType;
        this.dimension = dimension;
        this.velocity = Velocity.ZERO;
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
    public Point getPosition() {
        return position;
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
    public void onCollision(final Entity receiver) {
        // TODO Auto-generated method stub
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.position.translate(this.getVelocity().getXcomponent(), this.getVelocity().getYcomponent());
    }
}
