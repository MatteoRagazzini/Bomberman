package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.model.Direction;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.view.utilities.AnimationImpl;
import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Class to manage the view of monsters.
 *
 *
 */
public class MonsterView extends AbstractEntityView {
    private static final String MONSTERSSPATH = "/monsterSpriteSheet.png";
    private static final SpriteSheet monsterSpritesheet = new SpriteSheet(MONSTERSSPATH);
    private final AnimationImpl animation = new AnimationImpl();
/**
 * Create a monster view.
 * @param position where the monster is located
 * @param dimension the dimension of the monster
 * @param image the image of the monster
 * @param visible the visibility of the monster
 */
    public MonsterView(final Point position, final Dimension dimension) {
        super(position, dimension, monsterSpritesheet.getSprite(2, 1, 48), true); 
        animation.createAnimation(MONSTERSSPATH, 3, 50);
    }

    @Override
    public final void render(final Graphics g) {
        g.drawImage(getSprite(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
    }
}

