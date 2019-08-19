package it.unibo.bmbman.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.unibo.bmbman.controller.SoundsController;
import it.unibo.bmbman.controller.game.BombControllerImpl;
import it.unibo.bmbman.model.TerrainFactoryImpl;
import it.unibo.bmbman.model.entities.BombImpl;
import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.entities.Monster;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Position;
/**
 * JUnit Test for Bomb and BombController.
 *
 */
public class TestBomb {
    private BombControllerImpl bc;
    private BombImpl bomb;
    private HeroImpl hero;
    private SoundsController sc = new SoundsController();
    private static final Position HERO_POS = new Position(50, 100);
    private static final Position MONSTER1_POS = new Position(HERO_POS.getX() + TerrainFactoryImpl.CELL_DIMENSION, HERO_POS.getY());
    private static final Position MONSTER2_POS = new Position(HERO_POS.getX() + 5 * TerrainFactoryImpl.CELL_DIMENSION, HERO_POS.getY());
    private Monster monster1;
    private Monster monster2;
    /**
     * 
     */
    @Before
    public void init() {
        this.hero = new HeroImpl();
        this.hero.setPosition(HERO_POS);
        this.bc = new BombControllerImpl();
        this.sc.setEffectsOff();
    }
    /**
     * Test bomb planted.
     */
    @Test
    public void testBombsplanted() {
        this.bomb = this.bc.plantBomb(this.hero).get();
        Assert.assertEquals(this.bomb.getPosition(), this.hero.getPosition());
        Assert.assertEquals(this.bomb.getState(), BombState.PLANTED);
        this.hero.incrementBombsNumber();
        Assert.assertEquals(this.hero.getBombsNumber(), 2);
        Assert.assertTrue(this.bc.plantBomb(hero).isPresent());
        Assert.assertTrue(!this.bc.plantBomb(hero).isPresent());
        Assert.assertEquals(this.bc.getBombView().size(), 2);
    }
    /**
     * Test explosion with range 3 and collisions.
     */
    @Test 
    public void testExplosion() {
        this.bomb = this.bc.plantBomb(this.hero).get();
        Assert.assertTrue(this.bc.getBombsInExplosion().isEmpty());
        while (this.bomb.getState() == BombState.PLANTED) {
            this.bomb.update();
        }
        Assert.assertTrue(this.bomb.getState() == BombState.IN_EXPLOSION);
        Assert.assertTrue(this.bc.getBombsInExplosion().size() == 1);
        Assert.assertFalse(this.bomb.remove());
        Assert.assertEquals(this.hero.getBombsNumber(), 1);
        Assert.assertTrue(!this.bc.plantBomb(hero).isPresent());
        this.monster1 = new Monster(MONSTER1_POS);
        this.monster2 = new Monster(MONSTER2_POS);
        Set<Entity> set = new HashSet<>();
        set.add(monster1);
        set.add(monster2);
        set.add(hero);
        Assert.assertTrue(this.bc.getBombsInExplosion().size() == 1);
        Assert.assertTrue(this.bc.getBombsToRemove().isEmpty());
        this.bc.collision(set);
        Assert.assertTrue(this.bomb.getState() == BombState.EXPLODED);
        Assert.assertEquals(this.bc.getBombsToRemove().size(), 1);
        Assert.assertFalse(this.monster1.isAlive());
        Assert.assertTrue(this.monster2.isAlive());
        Assert.assertEquals(this.hero.getLives(), 2);
    }
}
