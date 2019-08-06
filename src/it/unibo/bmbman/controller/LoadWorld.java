package it.unibo.bmbman.controller;


import java.awt.image.BufferedImage;

import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Wall;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.HeroView;
import it.unibo.bmbman.view.entities.MonsterView;
import it.unibo.bmbman.view.entities.WallView;
/**
 * Used to load a level.
 */
public class LoadWorld {
    private final GameController gc;
    /**
     * Construct the level.
     * @param gc {@link GameController}
     */
    public LoadWorld(final GameController gc) {
        this.gc = gc;
    }
    /**
     * Loads all the entity.
     * @param levelImage the image from which load all the entities
     */
    public void loadEntity(final BufferedImage levelImage) {
//        final Wall wUP = new Wall(new Position(400, 80),  EntityType.WALL, new Dimension(50, 50));
//        final Wall wDOWN = new Wall(new Position(400, MyGUIFactory.FRAME_HEIGHT),  EntityType.WALL, new Dimension(50, 50));
//        final Wall w1 = new Wall(new Position(10, 100),  EntityType.WALL, new Dimension(50, 50));
//        final Wall wLEFT = new Wall(new Position(50, 260),  EntityType.WALL, new Dimension(50, 50));
//        final Wall wRIGHT = new Wall(new Position(700, 260), EntityType.WALL, new Dimension(50, 50));
//        final Hero hero = new Hero();
//        final HeroView heroView = new HeroView(hero.getPosition());
//        final Monster m = new Monster(new Position(500, 260));
//        final MonsterView mv = new MonsterView(m.getPosition());
//        final WallView wvup = new WallView(wUP.getPosition());
//        final WallView wvr = new WallView(wRIGHT.getPosition());
//        final WallView wv1 = new WallView(w1.getPosition());
//        final WallView wvd = new WallView(wDOWN.getPosition());
//        final WallView wvl = new WallView(wLEFT.getPosition());
//        this.gc.addEntity(wUP, wvup);
//        this.gc.addEntity(wDOWN, wvd);
//        this.gc.addEntity(wRIGHT, wvr);
//        this.gc.addEntity(w1, wv1);
//        this.gc.addEntity(wLEFT, wvl);
//        this.gc.addEntity(m, mv);
//        this.gc.addEntity(hero, heroView);
        for (int y = 0; y < levelImage.getHeight(); y++) {
            for (int x = 0; x < levelImage.getWidth(); x++) {
                int pixel = levelImage.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blu = (pixel) & 0xff;

                if(red == 0 && green == 0 && blu == 0) {
                    this.gc.addEntity(new Wall(new Position(x*50, y*50),  EntityType.WALL, new Dimension(50, 50)), new WallView(new Position(x*50, y*50)));
                }
                if(red == 0 && green == 0 && blu == 255) {
                    this.gc.addEntity(new Hero(new Position(x*48, y*48)), new HeroView(new Position(x*48, y*48)));
                }
                if(red == 255 && green == 0 && blu == 0) {
                    this.gc.addEntity(new Monster(new Position(x*48, y*48)), new MonsterView(new Position(x*48, y*48)));
                }
            }
        }
    }

}
