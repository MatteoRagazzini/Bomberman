package it.unibo.bmbman.view.entities;

import java.awt.geom.Dimension2D;

import it.unibo.bmbman.view.utilities.Sprite;

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
     * Used to know the width and height of the entityView.
     * @return  the dimension of entity view 
     */
    Dimension2D getDimension();
    /**
     * the method to update the graphics of entity.
     */
    void render();
    /**
     * Used to set the image of the entity.
     * @param image the sprite to set
     */
    void setSprite(Sprite image);
    /**
     * Used to get the image associated to the entity.
     * @return the sprite
     */
    Sprite getSprite();
    /**
     * Set the visibility of entity.
     * @param visibility if true the entity view is visible
     */
    void setVisibility(boolean visibility);
}
