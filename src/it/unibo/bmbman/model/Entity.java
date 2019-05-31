package it.unibo.bmbman.model;

import java.awt.Point;
import java.awt.Rectangle;

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
      * 
      */
     void remove();
     /**
      * 
      * @return entity's dimension
      */
     Rectangle getDimension();
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
}

