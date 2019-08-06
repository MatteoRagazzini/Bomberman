package it.unibo.bmbman.controller;


import it.unibo.bmbman.model.BonusVelocity;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Wall;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.MyGUIFactory;
import it.unibo.bmbman.view.entities.BonusVelocityView;
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
     */
    public void loadEntity() {
        final Wall wUP = new Wall(new Position(400, 80),  EntityType.WALL, new Dimension(50, 50));
        final Wall wDOWN = new Wall(new Position(400, MyGUIFactory.FRAME_HEIGHT),  EntityType.WALL, new Dimension(50, 50));
        final Wall w1 = new Wall(new Position(10, 100),  EntityType.WALL, new Dimension(50, 50));
        final Wall wLEFT = new Wall(new Position(50, 260),  EntityType.WALL, new Dimension(50, 50));
        final Wall wRIGHT = new Wall(new Position(700, 260), EntityType.WALL, new Dimension(50, 50));
        final BonusVelocity bonus1 = new BonusVelocity(new Position(400, 400), new Dimension(50, 50), this.gc);
        final Hero hero = new Hero(this.gc);
        final HeroView heroView = new HeroView(hero.getPosition());
        final Monster m = new Monster(new Position(500, 260));
        final MonsterView mv = new MonsterView(m.getPosition(), m.getDimension());
        final WallView wvup = new WallView(wUP.getPosition());
        final WallView wvr = new WallView(wRIGHT.getPosition());
        final WallView wv1 = new WallView(w1.getPosition());
        final WallView wvd = new WallView(wDOWN.getPosition());
        final WallView wvl = new WallView(wLEFT.getPosition());
        final BonusVelocityView bonus1view = new BonusVelocityView(bonus1.getPosition(), bonus1.getDimension(), true);
        this.gc.addEntity(wUP, wvup);
        this.gc.addEntity(wDOWN, wvd);
        this.gc.addEntity(wRIGHT, wvr);
        this.gc.addEntity(w1, wv1);
        this.gc.addEntity(wLEFT, wvl);
        this.gc.addEntity(m, mv);
        this.gc.addEntity(hero, heroView);
        this.gc.addEntity(bonus1, bonus1view);
    }

}
