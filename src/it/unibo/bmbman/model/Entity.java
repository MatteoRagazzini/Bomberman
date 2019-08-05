package it.unibo.bmbman.model;
import java.awt.Dimension;
import java.awt.Point;

import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 * models general aspects of entities.
 *
 */
public interface Entity {
    /**
     *
     * @return entity's position in the world
     */
    Position getPosition();
    /**
     * Used to set entity's position.
     * @param position new entity's position
     */
    void setPosition(Position position);
    /**
     * 
     */
    void remove();
    /**
     * 
     * @return entity's dimension
     */
    Dimension getDimension();
    /**
     * 
     * @return entity's type
     */
    EntityType getType();

    /**
     * Used to get {@link CollisionComponent}.
     * @return the {@link CollisionComponent} associated with this entity
     */
    CollisionComponent getCollisionComponent();
    /**
     * Used to modify entity behavior after collision.
     * @param receiver the entity with which this entity collided
     * @param newPosition new entity's position to avoid continuous collisions
     */
    void onCollision(Entity receiver, Position newPosition);
    /**
     * Used to update entity status during the game.
     */
    void update();
}
