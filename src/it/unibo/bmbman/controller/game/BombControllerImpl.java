package it.unibo.bmbman.controller.game;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.controller.SoundsController;
import it.unibo.bmbman.model.collision.CollisionImpl;
import it.unibo.bmbman.model.entities.Bomb;
import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BombView;
/**
 *
 */
public class BombControllerImpl implements BombController {
    private final List<Pair<Bomb, BombView>> amountBombs;
    /**
     */
    public BombControllerImpl() {
        super();
        this.amountBombs = new ArrayList<>();
        Bomb.resetBombNumber();
        Bomb.resetBonusRange();
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<Pair<Bomb, BombView>> getBombsToRemove() {
        return this.amountBombs.stream().filter(b -> b.getX().remove())
                .collect(Collectors.toList());
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<Bomb> getBombsInExplosion() {
        return this.amountBombs.stream()
                .filter(b -> b.getX().getState() == BombState.IN_EXPLOSION)
                .map(b -> b.getX())
                .collect(Collectors.toList());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BombView> getBombView() {
        return this.amountBombs.stream().map(b -> b.getY()).collect(Collectors.toSet());
    }
    /**
     * 
     * {@inheritDoc} 
     * 
     */
    @Override
    public Optional<Bomb> plantBomb(final Hero hero) {
        if (Bomb.getBombsNumber() - this.amountBombs.size() >= 1) {
            final Position pos = new Position(Position.getCenteredPosition(hero.getPosition()));
            final Bomb b = new Bomb(pos);
            b.startTimer();
            this.amountBombs.add(new Pair<Bomb, BombView>(b, new BombView(pos)));
            SoundsController.getPlaceBombSound().ifPresent(s -> s.play());

            return Optional.of(b);
        }
        return Optional.empty();
    }
    /**
     * 
     * {@inheritDoc} 
     */
    @Override
    public void update() {
        this.amountBombs.forEach(b -> b.getX().update());
        this.amountBombs.forEach(b -> {
            b.getY().setBombState(b.getX().getState());
            if (b.getX().getState() == BombState.IN_EXPLOSION) {
                    SoundsController.getExplosionSound().ifPresent(s -> s.play());
            }
        });
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void removeBomb() {
        this.amountBombs.removeAll(getBombsToRemove());
    }
    /**
     * 
     * {@inheritDoc} 
     */
    @Override
    public void collision(final Set<Entity> entities) {
        this.getBombsInExplosion().forEach(b -> {
            entities.forEach(e -> {
                if (checkCollision(e, b.getExplosion().getX()) || checkCollision(e, b.getExplosion().getY())) {
                    this.notifyCollision(e, b);
                }
            });
        });
        this.getBombsInExplosion().forEach(b -> b.setBombExploded());
    }
    private boolean checkCollision(final Entity receiver, final Rectangle collider) {
        return receiver.getCollisionComponent().getHitbox().intersects(collider);
    }
    private void notifyCollision(final Entity receiver, final Bomb b) {
        receiver.onCollision(new CollisionImpl(b, receiver.getPosition()));
    }
}
