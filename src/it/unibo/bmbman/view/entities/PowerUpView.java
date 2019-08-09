package it.unibo.bmbman.view.entities;

import java.awt.Image;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Create the power-up view.
 */
public class PowerUpView extends AbstractEntityView {
    private final String imagePath;
    private final SpriteSheet ss;
    private final Image idleImage;
    private static final int DIMENSION = 50;
    /**
     * Constructor for a general power-up.
     * @param position where is the power-up in our terrain
     * @param dimension the dimension of the power-up
     * @param visible if the power-up is visible or not
     * @param path the path of the image to load.
     */
    public PowerUpView(final Position position, final Dimension dimension, final boolean visible, final String path) {
        super(position, dimension, visible);
        this.imagePath = path;
        this.ss = new SpriteSheet(imagePath);
        this.idleImage = ss.getSprite(1, 1, DIMENSION);
    }
    /**
     * Load the image of the power-up.
     */
    @Override
    public Image getSprite() {
        return idleImage;
    }
}
