package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.view.utilities.SpriteSheet;

public class WallView extends AbstractEntityView {

    private static final String WALL_PATH = "/wall.png";
    private final static SpriteSheet ss = new SpriteSheet(WALL_PATH);
    private final static Image idleImage = ss.getSprite(1, 1, 50);
    

    public WallView(Point position) {
        super(position, new Dimension(50,50), true);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Image getSprite() {
        return idleImage;
    }

}
