package it.unibo.bmbman.controller;


import it.unibo.bmbman.model.Block;
import it.unibo.bmbman.model.BonusVelocity;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.MalusFreeze;
import it.unibo.bmbman.model.MalusInvert;
import it.unibo.bmbman.model.MalusSlow;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.Tile;
import it.unibo.bmbman.model.Wall;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.MyGUIFactory;
import it.unibo.bmbman.view.entities.BlockView;
import it.unibo.bmbman.view.entities.BonusVelocityView;
import it.unibo.bmbman.view.entities.HeroView;
import it.unibo.bmbman.view.entities.MalusFreezeView;
import it.unibo.bmbman.view.entities.MalusInvertView;
import it.unibo.bmbman.view.entities.MalusSlowView;
import it.unibo.bmbman.view.entities.MonsterView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;
import it.unibo.bmbman.view.utilities.Sprite;
import it.unibo.bmbman.view.utilities.SpriteSheet;
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
     */
    public void loadEntity() {
        final Terrain terrain = new Terrain(); 
        final Wall wUP = new Wall(new Position(400, 80), new Dimension(50, 50));
        final Wall wDOWN = new Wall(new Position(400, MyGUIFactory.FRAME_HEIGHT),  new Dimension(50, 50));
        final Wall w1 = new Wall(new Position(10, 100),  new Dimension(50, 50));
        final Wall wLEFT = new Wall(new Position(50, 260),  new Dimension(50, 50));
        final Wall wRIGHT = new Wall(new Position(700, 260), new Dimension(50, 50));
        final Block block = new Block(new Position(200, 0), new Dimension(50, 50));
        final BlockView blockview = new BlockView(block.getPosition());
        final Tile tile0 = new Tile(new Position(0, 0), new Dimension(50, 50));
        final Tile tile1 = new Tile(new Position(50, 0), new Dimension(50, 50));
        final Tile tile2 = new Tile(new Position(100, 0), new Dimension(50, 50));
        final Tile tile3 = new Tile(new Position(150, 0), new Dimension(50, 50));
        final Tile tile4 = new Tile(new Position(200, 0), new Dimension(50, 50));
        final Hero hero = new Hero(this.gc);
        final HeroView heroView = new HeroView(hero.getPosition());
        final Monster m = new Monster(new Position(500, 260));
        final MonsterView mv = new MonsterView(m.getPosition(), m.getDimension());
        final WallView wvup = new WallView(wUP.getPosition());
        final WallView wvr = new WallView(wRIGHT.getPosition());
        final WallView wv1 = new WallView(w1.getPosition());
        final WallView wvd = new WallView(wDOWN.getPosition());
        final WallView wvl = new WallView(wLEFT.getPosition());
        // Creo i malus
        final MalusFreeze malus1 = new MalusFreeze(new Position(400, 400), new Dimension(50, 50));
        final MalusFreezeView malus1view = new MalusFreezeView(malus1.getPosition(), malus1.getDimension(), true);
        final MalusInvert malus2 = new MalusInvert(new Position(450, 400), new Dimension(50, 50));
        final MalusInvertView malus2view = new MalusInvertView(malus2.getPosition(), malus2.getDimension(), true);
        final MalusSlow malus3 = new MalusSlow(new Position(500, 400), new Dimension(50, 50));
        final MalusSlowView malus3view = new MalusSlowView(malus3.getPosition(), malus3.getDimension(), true);
        // Creo i bonus
        final BonusVelocity bonus3 = new BonusVelocity(new Position(400, 450), new Dimension(50, 50));
        final BonusVelocityView bonus3view = new BonusVelocityView(bonus3.getPosition(), bonus3.getDimension(), true);
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 13; j++) {
            this.gc.addEntity(terrain.getEntity(i, j), terrain.getEntityView(terrain.getEntity(i, j)));
            }
        }
        /*
        this.gc.addEntity(tile0, new TileView(tile0.getPosition()));
        this.gc.addEntity(tile1, new TileView(tile1.getPosition()));
        this.gc.addEntity(tile2, new TileView(tile2.getPosition()));
        this.gc.addEntity(tile3, new TileView(tile3.getPosition()));
        this.gc.addEntity(tile4, new TileView(tile4.getPosition()));
        */
        this.gc.addEntity(block, blockview);
        this.gc.addEntity(wUP, wvup);
        this.gc.addEntity(wDOWN, wvd);
        this.gc.addEntity(wRIGHT, wvr);
        this.gc.addEntity(w1, wv1);
        this.gc.addEntity(wLEFT, wvl);
        this.gc.addEntity(m, mv);
        this.gc.addEntity(hero, heroView);
        this.gc.addEntity(malus1, malus1view);
        this.gc.addEntity(malus2, malus2view);
        this.gc.addEntity(malus3, malus3view);
        this.gc.addEntity(bonus3, bonus3view);
    }

}
