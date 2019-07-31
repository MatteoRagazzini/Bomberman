package it.unibo.bmbman.model;

import java.awt.Rectangle;
/**
 * Interface to CollisionComponent.
 */
public interface CollisionComponent {
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
}
