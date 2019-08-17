package it.unibo.bmbman.model.entities;
import it.unibo.bmbman.model.utilities.Direction;
import it.unibo.bmbman.model.utilities.Velocity;
/**
 * Interface to model a living entity that is an entity with one or more lives and capable of moving.
 *
 */
public interface LivingEntity extends Entity {
    /**
     * 
     * @return true if the entity still has one or more lives, false otherwise
     */
    boolean isAlive();
    /**
     * Add a life.
     */
    void addLife();
    /**
     * Remove a life.
     */
    void removeLife();
    /**
     * 
     * @return the number of lives of the entity
     */
    int getLives();
    /**
     * Used to set entity's position.
     */
    void move();
    /**
     * Used to know the velocity of the entity.
     * @return the velocity
     */
    Velocity getVelocity();
    /**
     * Used to set entity's velocity.
     * @param velocity the value of velocity
     */
    void setVelocity(Velocity velocity);
    /**
     * set direction in which the entity must move.
     * @param direction 
     */
    void setDirection(Direction direction);
    /**
     * 
     * @return the direction in which the entity is moving
     */
    Direction getDirection();
}
