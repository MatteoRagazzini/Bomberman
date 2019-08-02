package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.view.utilities.Sprite;

/**
 * Interface to model the general view aspects of each entity in the game.
 *
 */
public interface EntityView {

   /**
     * Set the position of entity view.
     * @param position the point in the world
     */
    void setPosition(Point position);
    /**
     * Used to know where is the entity view.
     * @return the position
     */
    Point getPosition();
       /**
     * Set the dimension of entity view.
     * @param dimension the height and width of the entity view
     */
    void setDimension(Dimension dimension);
    /**
     * Used to know the width and height of the entityView.
     * @return  the dimension of entity view 
     */
    Dimension getDimension();
    /**
     * the method to update the graphics of entity.
     */
    void render();
    /**
     * Used to set the image of the entity.
     * @param image the sprite to set
     */
    void setSprite(Image image);
    /**
     * Used to get the image associated to the entity.
     * @return the sprite
     */
    Image getSprite();
    /**
     * Set the visibility of entity.
     * @param visible if true the entity view is visible
     */
    void setVisible(boolean visible);
    /**
     * Used to know if the entity is visible or not.
     * @return true if entity is visible, false otherwise
     */
    boolean getVisible();
}
