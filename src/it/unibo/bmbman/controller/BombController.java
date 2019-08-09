package it.unibo.bmbman.controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BombView;
/**
 *
 */
public class BombController {
    private List<Pair<Bomb, BombView>> amountBombs;
    /**
     */
    public BombController() {
        super();
        this.amountBombs = new ArrayList<>();
    }
    /**
     * 
     * @return bombs exploded
     */
    public Set<Bomb> getBombsToRemove() {
        return this.amountBombs.stream().filter(b -> b.getX().remove())
                                        .map(b -> b.getX())
                                        .collect(Collectors.toSet());
    }
    /**
     * 
     * @return plantedBombs
     */
//    public List<Bomb> getPlantedBomb() {
//        return this.amountBombs.stream()
//                               .filter(b -> b.isPlanted())
//                               .collect(Collectors.toList());
//    }
    /**
     * 
     * @param hero 
     * @return bomb that hero can plant, otherwise an empty optional
     */
    public Optional<Bomb> plantBomb(final Hero hero) {
        if (hero.getBombNumber() - this.amountBombs.size() >= 1) {
            final Position pos = new Position(hero.getPosition().getX(), hero.getPosition().getY());
            final Bomb b = new Bomb(pos);
            b.setPlanted(true);
            b.startTimer();
            this.amountBombs.add(new Pair<Bomb, BombView>(b, new BombView(pos)));
            return Optional.of(b);
        }
        return Optional.empty();
    }
    /**
     * 
     * @param g 
     */
    public void update(final Graphics g) {
        this.amountBombs.forEach(b -> b.getX().update());
        this.amountBombs.removeAll(this.amountBombs.stream().filter(b -> b.getX().remove()).collect(Collectors.toList()));
        this.amountBombs.forEach(b -> b.getY().render(g));
    }
    /**
     * 
     * @param entities 
     */
    public void collision(final Set<Entity> entities) {
        this.getBombsToRemove().forEach(b -> {
                entities.forEach(e -> {
                    if (checkCollision(e, b.getExplosion().getX()) || checkCollision(e, b.getExplosion().getY())) {
                        this.notifyCollision(e, b, e.getPosition());
                    }
                });
        });
    }
    private boolean checkCollision(final Entity receiver, final Rectangle collider) {
        return receiver.getCollisionComponent().getHitbox().intersects(collider);
    }
    private void notifyCollision(final Entity receiver, final Bomb b, final Position position) {
        receiver.onCollision(b, receiver.getPosition());
    }
}
