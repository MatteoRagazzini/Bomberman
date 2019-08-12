package it.unibo.bmbman.view.entities;


import java.awt.Image;
import java.util.EnumMap;
import java.util.HashMap;
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
    private static final String PATH_EXPLOSION_IMAGES = "/bombs/explosion.png";
    private static final int DIMENSION = 50;
    private static final int FRAME_PER_ANIMATION = 6;
    private final Animation spriteBomb = new AnimationImpl();
    private final Animation spriteExplosion = new AnimationImpl();
    private final Map<BombState, Animation> sprite = new HashMap<>();
    private BombState state; 
    /**
     * Create a monster view.
     * @param position where the monster is located
     */
    public BombView(final Position position) {
        super(position, new Dimension(DIMENSION, DIMENSION), true); 
        this.spriteBomb.createAnimation(PATH_BOMB_IMAGES, FRAME_PER_ANIMATION, DIMENSION);
        this.spriteExplosion.createAnimation(PATH_EXPLOSION_IMAGES, FRAME_PER_ANIMATION, DIMENSION);
        this.state = BombState.PLANTED; 
        fillMap();
    }
    /**
     * Method to set the bomb state.
     * @param state the actual state of the bomb
     */
    public void setBombState(final BombState state) {
        this.state = state;
    }
    /** 
     * Method to fill the map <state, animation>.
     */
    private void fillMap() {
        sprite.put(BombState.PLANTED, spriteBomb);
        sprite.put(BombState.IN_EXPLOSION, spriteExplosion);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Image getSprite() {
        return this.sprite.get(this.state).getNextImage();
    }
}

