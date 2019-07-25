package it.unibo.bmbman.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * Models the general aspects of a living entity.
 *
 */
public abstract class AbstractLivingEntity implements LivingEntity, Entity {
    private Point2D position;
    private int lives;
    private boolean solidity;
    private EntityType entityType;
    private Dimension2D dimension;
    private int speed;
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
    public AbstractLivingEntity(final Point2D position, final int lives, final boolean solidity, final EntityType entityType, final Dimension2D dimension) {
        this.position = position;
        this.lives = lives;
        this.solidity = solidity;
        this.entityType = entityType;
        this.dimension = dimension;
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
    public Dimension2D getDimension() {
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

    @Override
    public void removeLife() {
        this.lives = this.lives - 1 > 0 ? this.lives - 1 : 0; 
    }

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public abstract void move(Point2D position);

    @Override
    public void incrementSpeed(final int s) {
        this.speed = this.speed + s;
    }

    @Override
    public void decrementSpeed(final int s) {
        this.speed = this.speed - s;
    }

    @Override
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }
}
