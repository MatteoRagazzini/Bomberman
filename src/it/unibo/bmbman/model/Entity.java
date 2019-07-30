package it.unibo.bmbman.model;


import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
    Point2D getPosition();
    /**
     * Used to set entity's position.
     * @param position new entity's position
     */
    void setPosition(Point2D position);
    /**
     * 
     */
    void remove();
    /**
     * 
     * @return entity's dimension
     */
    Rectangle2D getDimension();
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
    * Used to modify entity behavior.
    */
    void onCollision(Entity receiver);
    
    void update();
}
