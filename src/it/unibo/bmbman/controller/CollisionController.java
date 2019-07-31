package it.unibo.bmbman.controller;

import java.util.Set;

import it.unibo.bmbman.model.Entity;

/**
 * Collision Manager.
 */
public interface CollisionController {
    /**
     * Determines if the followed entity is in collision with one of the entity in set.
     * @param entities set of {@link Entity}
     */
    void collision(Set<Entity> entities);
    /**
     * Used to notify the followed entity a collision.
     * @param receiver {@link Entity} with which the collision occurred
     */
    void notifyCollision(Entity receiver);

}
