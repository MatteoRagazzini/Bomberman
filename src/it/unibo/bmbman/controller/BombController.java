package it.unibo.bmbman.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 * @author lucia
 *
 */
public class BombController {
    private LinkedList<Bomb> amountBombs;
    private final GameController gc;
    /**
     * 
     * @param gc 
     */
    public BombController(final GameController gc) {
        super();
        this.amountBombs = new LinkedList<>();
        this.gc = gc;
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
     * @param bomb 
     */
    public void addBomb(final Bomb bomb) {
        final Bomb b = new Bomb(new Dimension(40,40));
        this.amountBombs.add(b);
        //this.gc.addEntity(b, entityView);
    }

    void plantBomb(final Position pos) {
        if (this.amountBombs.size() > 1) {
            final Bomb b = amountBombs.getLast();
            b.setPosition(pos);
            b.setPlanted(true);
            b.startTimer();
            System.out.println("piantata");
        }
    }
//    void startExplosion() {
//        new Explosion(bomb.getPosition(), null, dimension)
//    }
}
