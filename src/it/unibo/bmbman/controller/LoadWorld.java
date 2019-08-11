package it.unibo.bmbman.controller;



import it.unibo.bmbman.model.BonusLife;
import it.unibo.bmbman.model.BonusVelocity;
import it.unibo.bmbman.model.Hero;

import it.unibo.bmbman.model.MalusFreeze;
import it.unibo.bmbman.model.MalusInvert;
import it.unibo.bmbman.model.MalusSlow;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.HeroView;
import it.unibo.bmbman.view.entities.MonsterView;

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
//        final Wall wUP = new Wall(new Position(400, 80), new Dimension(50, 50));
//        final Wall wDOWN = new Wall(new Position(400, MyGUIFactory.FRAME_HEIGHT),  new Dimension(50, 50));
//        final Wall w1 = new Wall(new Position(10, 100),  new Dimension(50, 50));
//        final Wall wLEFT = new Wall(new Position(50, 260),  new Dimension(50, 50));
//        final Wall wRIGHT = new Wall(new Position(700, 260), new Dimension(50, 50));
//        final Block block = new Block(new Position(200, 0), new Dimension(50, 50));
//        final BlockView blockview = new BlockView(block.getPosition());
        final Hero hero = new Hero(this.gc);
        final HeroView heroView = new HeroView(hero.getPosition());
        final Monster m = new Monster(new Position(500, 260));
        final MonsterView mv = new MonsterView(m.getPosition(), m.getDimension());
//        final WallView wvup = new WallView(wUP.getPosition());
//        final WallView wvr = new WallView(wRIGHT.getPosition());
//        final WallView wv1 = new WallView(w1.getPosition());
//        final WallView wvd = new WallView(wDOWN.getPosition());
//        final WallView wvl = new WallView(wLEFT.getPosition());
        // Creo i malus
//        final MalusFreeze malus1 = new MalusFreeze(new Position(250, 150), new Dimension(50, 50));
//        final MalusInvert malus2 = new MalusInvert(new Position(450, 250), new Dimension(50, 50));
//        final MalusSlow malus3 = new MalusSlow(new Position(650, 400), new Dimension(50, 50));
//        // Creo i bonus
//        final BonusVelocity bonus3 = new BonusVelocity(new Position(400, 450), new Dimension(50, 50));
//        final BonusLife bLife = new BonusLife(new Position(550, 250), new Dimension(50, 50));
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
            this.gc.addEntity(terrain.getEntity(i, j), terrain.getEntityView(terrain.getEntity(i, j)));
            }
        }
        terrain.getTiles();
        terrain.getBlocks().stream().forEach((i) -> gc.addEntity(i, terrain.getEntityView(i)));

        this.gc.addEntity(m, mv);
        this.gc.addEntity(hero, heroView);

        this.gc.addEntity(new Monster(new Position(150, 150)), new MonsterView(new Position(150, 150), new Dimension(48, 48)));

    }

}
