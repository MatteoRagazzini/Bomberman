package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import it.unibo.bmbman.controller.GameController;
import it.unibo.bmbman.controller.GameControllerImpl;
import it.unibo.bmbman.controller.KeyInput;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Tile;
import it.unibo.bmbman.model.Wall;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.HeroView;
import it.unibo.bmbman.view.entities.MonsterView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;
import it.unibo.bmbman.view.utilities.Sprite;
import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView {

    private final GUIFactory gui = new MyGUIFactory();
    private final Canvas canvas = new Canvas(); 
    private final JFrame frame = gui.createFrame();
    private final GameController game = new GameControllerImpl();
    private final Wall wUP = new Wall(new Position(400, 80),  EntityType.WALL, new Dimension(50, 50));
    private final Wall wDOWN = new Wall(new Position(400, MyGUIFactory.FRAME_HEIGHT),  EntityType.WALL, new Dimension(50, 50));
    private final Wall w1 = new Wall(new Position(10, 100),  EntityType.WALL, new Dimension(50, 50));
    private final Wall wLEFT = new Wall(new Position(50, 260),  EntityType.WALL, new Dimension(50, 50));
    private final Wall wRIGHT = new Wall(new Position(700, 260), EntityType.WALL, new Dimension(50, 50));
    private final Hero hero = new Hero();
    private final HeroView heroView = new HeroView(hero.getPosition());
    private final Monster m = new Monster(new Position(500, 260));
    private final MonsterView mv = new MonsterView(m.getPosition(), m.getDimension());
    private final WallView wvup = new WallView(wUP.getPosition());
    private final WallView wvr = new WallView(wRIGHT.getPosition());
    private final WallView wv1 = new WallView(w1.getPosition());
    private final WallView wvd = new WallView(wDOWN.getPosition());
    private final WallView wvl = new WallView(wLEFT.getPosition());
    private final Tile tile = new Tile(new Position(0, 0), new Dimension(17, 17));
    private final TileView tv = new TileView(tile.getPosition(), tile.getDimension(), (new Sprite(new SpriteSheet("/Tilegrass.png"), 1, 1, 17)).getImage(), true);
    /**
     * construct the frame.
     */
    public SinglePlayerView() {
        canvas.setSize(MyGUIFactory.FRAME_WIDTH, MyGUIFactory.FRAME_HEIGHT);
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.addKeyListener(new KeyInput(game));
        frame.setVisible(true);
        game.addEntity(wUP, wvup);
        game.addEntity(wDOWN, wvd);
        game.addEntity(wRIGHT, wvr);
        game.addEntity(w1, wv1);
        game.addEntity(wLEFT, wvl);
        game.addEntity(m, mv);
        game.addEntity(hero, heroView);
        game.addEntity(tile, tv);

    }
    /**
     * get the frame.
     * @return the current frame
     */
    public JFrame getFrame() {
        return this.frame;
    }
    /**
     * used to update graphics component.
     */
    public void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        Graphics bg = bs.getDrawGraphics();
        bg.setColor(Color.black);
        bg.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        game.update(bs.getDrawGraphics());
//        addWall(wUP, bs);
//        addWall(wDOWN, bs);
//        addWall(wLEFT, bs);
//        addWall(wRIGHT, bs);
//        addWall(w1, bs);
//        Graphics gm = bs.getDrawGraphics();
//        Graphics gf = bs.getDrawGraphics();
//        gf.drawImage(tv.getSprite(), tile.getPosition().x, tile.getPosition().y, tile.getDimension().width, tile.getDimension().height, null);
//        gm.setColor(Color.GREEN);
//        gm.fillRect((int) m.getPosition().getX(), (int) m.getPosition().getY(), (int) m.getDimension().getWidth(), (int) m.getDimension().getHeight());
//        Graphics gh = bs.getDrawGraphics();
//        gh.drawImage(heroView.getSprite(), hero.getPosition().x, hero.getPosition().y, heroView.getDimension().width, heroView.getDimension().height, null);
         bs.show();
    }
    private void addWall(final Wall w, final BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.RED);
        g.fillRect((int) w.getPosition().getX(), (int) w.getPosition().getY(), (int) w.getDimension().getWidth(), (int) w.getDimension().getHeight());
        g.dispose();
    }
}
