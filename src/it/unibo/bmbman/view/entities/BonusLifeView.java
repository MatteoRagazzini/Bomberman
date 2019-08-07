package it.unibo.bmbman.view.entities;

import java.awt.Image;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.utilities.SpriteSheet;

public class BonusLifeView extends AbstractEntityView {
    private static final String BONUS_VEL_PATH = "/prova.png";
    private final SpriteSheet ss = new SpriteSheet(BONUS_VEL_PATH);
    private final Image idleImage = ss.getSprite(1, 1, 50);
    /**
     * Constructor for a Bonus Velocity power-up.
     * @param position where is the power-up in our terrain
     * @param dimension the dimension of the power-up
     * @param visible if the power-up is visible or not
     */
    public BonusLifeView(final Position position, final Dimension dimension, final boolean visible) {
        super(position, dimension, visible);
    }
    /**
     * Load the image of the power-up.
     */
    @Override
    public Image getSprite() {
        return idleImage;
    }
}
