package it.unibo.bmbman.view.entities;

import java.awt.geom.Dimension2D;

/**
 * Interface to model the general view aspects of each entity in the game.
 *
 */
public interface EntityView {

//   /**
//     * Set the position of entity view.
//     * @param position the point in the world
//     */
//    void setPosition(Point2D position);
//    /**
//     * Used to know where is the entity view.
//     * @return the position
//     */
//    Point2D getPosition();
       /**
     * Set the dimension of entity view.
     * @param dimension the height and width of the entity view
     */
    void setDimension(Dimension2D dimension);
    /**
     * 
     * @return  the dimension of entity view
     */
    Dimension2D getDimension();
    /**
     * the method to update the graphics of entity.
     */
    void render();
 //   Sprite getSprite();
    /**
     * Set the visibility of entity.
     * @param visibility if true the entity view is visible
     */
    void setVisibility(boolean visibility);
}
