package it.unibo.bmbman.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.unibo.bmbman.controller.game.BombControllerImpl;
import it.unibo.bmbman.model.entities.Bomb;
import it.unibo.bmbman.model.entities.BombImpl;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Position;
/**
 * JUnit Test for Bomb and BombController.
 *
 */
public class TestBomb {
    private BombControllerImpl bc;
    private final List<Bomb> amountBombs = new ArrayList<>();
    private BombImpl bomb;
    private Position pos;
    private int range;
    private BombState state;
    /**
     * 
     */
    @Before
    public void init() {
        this.range = 3;
        this.pos = new Position(50, 100);
        this.bomb = new BombImpl(this.pos, this.range);
        this.bc = new BombControllerImpl();
    }
    /**
     * 
     */
    @Test 
    public void testBombsPlanted() {
        Assert.assertEquals(this.bomb.getPosition().getX(), 50);
        Assert.assertEquals(this.bomb.getPosition().getY(), 100);
        Assert.assertEquals(this.bomb.getState(), BombState.PLANTED);
        this.bomb.startTimer();
        this.amountBombs.add(this.bomb);
        Assert.assertEquals(this.amountBombs.size(), 1);
        Assert.assertTrue(this.bomb.getState() == BombState.PLANTED);
    }
    /**
     * 
     */
    public void testExplosion() {
    }
}
