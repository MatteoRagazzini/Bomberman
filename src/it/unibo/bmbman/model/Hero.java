package it.unibo.bmbman.model;

import java.awt.Dimension;
import java.awt.Point;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
/**
 * Representing a hero in our application.
 */
public class Hero extends AbstractLivingEntity {
    /**
     * Construct a Hero in game.
     */
    public Hero() {
        super(new Point(200, 200), EntityType.HERO, new Dimension(50, 50), 3);
    }

    @Override
    public void onCollision(final Entity receiver, final Point newPosition) {
        this.setPosition(newPosition);
        this.setDirection(Direction.IDLE);
        System.out.println("Eroe colliso con" + receiver.getType());
        if (receiver.getType() == EntityType.MONSTER) {
            this.removeLife();
        }

    }

    @Override
    protected void reachedBorder() {

    }

}
