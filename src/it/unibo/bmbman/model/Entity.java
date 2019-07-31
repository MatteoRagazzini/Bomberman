package it.unibo.bmbman.model;
import java.awt.Dimension;
import java.awt.Point;
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
    Point getPosition();
    /**
     * Used to set entity's position.
     * @param position new entity's position
     */
    void setPosition(Point position);
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
     * @return if entity is solid
     */
    boolean isSolid();
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
     */
    void onCollision(Entity receiver);
    /**
     * Used to update entity status during the game.
     */
    void update();
}
