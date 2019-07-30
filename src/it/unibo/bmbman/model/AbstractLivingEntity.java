package it.unibo.bmbman.model;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import it.unibo.bmbman.model.utilities.Velocity;

/**
 * Models the general aspects of a living entity.
 *
 */
public abstract class AbstractLivingEntity implements LivingEntity, Entity {
    private Point2D position;
    private int lives;
    private boolean solidity;
    private EntityType entityType;
    private Rectangle2D dimension;
    private Velocity velocity;
    private Direction direction;
    //la velocità all'inizio quanto vale?
    /**
     * Create a living entity.
     * @param position the point in the game world
     * @param lives how many lives the entity has.
     * @param solidity if the entity is solid
     * @param entityType which type of game entity is
     * @param dimension width and height  of the entity
     */
    public AbstractLivingEntity(final Point2D position, final int lives, final boolean solidity, final EntityType entityType, final Rectangle2D dimension) {
        this.position = position;
        this.lives = lives;
        this.solidity = solidity;
        this.entityType = entityType;
        this.dimension = dimension;
        this.velocity = Velocity.ZERO;
    }

    @Override
    public void setPosition(Point2D position) {
        this.position=position;
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
     * 
     */
    @Override
    public void removeLife() {
        this.lives = this.lives - 1 > 0 ? this.lives - 1 : 0; 
    }
    /**
     * 
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
     * return the velocity.
     * @return this velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * Used to set entity's velocity.
     * @param velocity the value of velocity
     */
    public void setVelocity(final Velocity velocity) {
        this.velocity = velocity;
    }
    /**
     * 
     */
    @Override
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }
    /**
     * 
     */
    @Override
    public Direction getDirection() {
        return this.direction;
    }
    /**
     * Used to notify the entity of a collision.
     */
    @Override
    public void onCollision(final Entity receiver) {
        // TODO Auto-generated method stub
    }
    @Override
    public void update() {
        setPosition(new Point2D.Double(this.getPosition().getX() + this.getVelocity().getXcomponent(),
                this.getPosition().getY() + this.getVelocity().getYcomponent()));
    }
}
