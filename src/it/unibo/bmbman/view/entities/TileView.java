package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.view.utilities.Sprite;
import it.unibo.bmbman.view.utilities.SpriteSheet;

public class TileView extends AbstractEntityView{
    private static final int GRASS_SPRITE_DIMENSION = 17;
/**
 * used to create a tile.
 * @param position the object position
 * @param dimension the image dimension
 * @param image the sprite 
 * @param visible if is visible or not
 */
    public TileView(final Point position, final Dimension dimension, final Image image, final boolean visible) {
        super(new Point(0, 0), new Dimension(GRASS_SPRITE_DIMENSION,GRASS_SPRITE_DIMENSION) , (new Sprite(new SpriteSheet("/Tilegrass.png"), 1, 1, 17)).getImage(), true);
    }
/**
 * 
 */
    @Override
    public void render() {
    }

}
