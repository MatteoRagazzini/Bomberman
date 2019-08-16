package it.unibo.bmbman.model.collision;

import java.awt.Rectangle;

import it.unibo.bmbman.model.entities.Entity;
/**
 * Interface to CollisionComponent.
 */
public interface CollisionComponent {

    /**
     * Used to get the entity associated.
     * @return {@link Entity}
     */
    Entity getFollowedEntity();
    /**
     * used to determine the area occupied by the entity.
     * @return a {@link Rectangle}
     */
    Rectangle getHitbox();
    /**
     * used to determine the area occupied by the entity 
     * while it is moving up.
     * @return a {@link Rectangle}
     */
    Rectangle getTopHitbox();
    /**
     * used to determine the area occupied by the entity.
     * @return a {@link Rectangle}
     */
    Rectangle getBottomHitbox();
    /**
     * used to determine the area occupied by the entity.
     * @return a {@link Rectangle}
     */
    Rectangle getLeftHitbox();
    /**
     * used to determine the area occupied by the entity.
     * @return a {@link Rectangle}
     */
    Rectangle getRightHitbox();
    /**
     * Used to notify the entity a {@link Collision}.
     * @param c {@link Collision}
     */
    void notifyCollision(Collision c);
}
