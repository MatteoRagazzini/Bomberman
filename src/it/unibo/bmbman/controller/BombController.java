package it.unibo.bmbman.controller;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Explosion;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 * @author lucia
 *
 */
public class BombController {
    private LinkedList<Bomb> amountBombs;
    /**
     * 
     * @param worldEntity 
     */
    public BombController(final List<Entity> worldEntity) {
        super();
        this.amountBombs = new LinkedList<>();
        //worldEntity.add(addBomb());
    }
    /**
     * 
     * @return bomb
     */
    public List<Bomb> getBomb() {
        return this.amountBombs;
    }
    /**
     * 
     * @return plantedBombs
     */
    public List<Bomb> getPlantedBomb() {
        return this.amountBombs.stream()
                               .filter(b -> b.isPlanted())
                               .collect(Collectors.toList());
    }
    /**
     * 
     * @return bomb
     */
    public Bomb addBomb() {
       // System.out.println("add bomb");
        final Bomb b = new Bomb(new Dimension(40, 40));
        this.amountBombs.add(b);
        return b;
    }
    /**
     * 
     */
    public void removeBomb() {
        final List<Bomb> bombToRemove = getBomb().stream().filter(b -> b.remove()).collect(Collectors.toList());
        this.amountBombs.removeAll(bombToRemove);
    }
    /**
     * 
     * @param pos 
     */
    public void plantBomb(final Position pos) {
        if (this.amountBombs.size() >= 1) {
            final Bomb b = amountBombs.getLast();
            //b.setPosition(pos); mi dà errore
            b.setPlanted(true);
            b.startTimer();
            //System.out.println("piantata bomba");
        }
    }
    /**
     * 
     */
    public void update() {
    }
    /**
     * 
     */
    public void startExplosion() {
        //final Explosion e = new Explosion(bomb.getPosition(), null, dimension);
       // e.setIsStarted();
    }
}
