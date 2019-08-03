package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Class to create Hero view.
 */
public class HeroView extends AbstractEntityView {

    private static final String PATH_HERO_IMAGES = "/AvengerSprite.png";
    private final static SpriteSheet ss = new SpriteSheet(PATH_HERO_IMAGES);
    private final static Image idleImage = ss.getSprite(8, 5, 48);
    /**
     * Construct an {@link HeroView}.
     * @param position position of enitity
     */
    public HeroView(final Point position) {
        super(position, new Dimension(48, 48), idleImage , true);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void render(final Graphics g) {
        g.drawImage(getSprite(), getPosition().x, getPosition().y, getDimension().width, getDimension().height, null);
    }

}
