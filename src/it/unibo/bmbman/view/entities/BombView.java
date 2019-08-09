package it.unibo.bmbman.view.entities;


import java.awt.Image;
import java.util.EnumMap;
import java.util.Map;
import it.unibo.bmbman.model.Direction;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.utilities.Animation;
import it.unibo.bmbman.view.utilities.AnimationImpl;
/**
 * Class to manage the view of monsters.
 *
 *
 */
public class BombView extends AbstractEntityView {
    private static final String PATH_BOMB_IMAGES = "/bombs/bomb.png";
    private static final int DIMENSION = 50;
    private static final int FRAME_PER_ANIMATION = 2;
    private final Animation sprites = new AnimationImpl();

    /**
     * Create a monster view.
     * @param position where the monster is located
     */
    public BombView(final Position position) {
        super(position, new Dimension(DIMENSION, DIMENSION), true); 
        this.sprites.createAnimation(PATH_BOMB_IMAGES, FRAME_PER_ANIMATION, DIMENSION);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Image getSprite() {
        return this.sprites.getNextImage();
    }
}

