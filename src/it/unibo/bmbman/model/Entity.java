package it.unibo.bmbman.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
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
     * 
     */
    void remove();
    /**
     * 
     * @return entity's dimension
     */
    Dimension2D getDimension();
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
}
