package it.unibo.bmbman.model.entities;

import it.unibo.bmbman.model.collision.Collision;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Direction;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.model.utilities.Velocity;
/**
 * Representing a hero in our application.
 */
public class Hero extends AbstractLivingEntity {
    private Double velocityModifier = 1.0;
    private int lifeToRemove;
    private boolean gotKey;
    private boolean win;
    private static final int START_POSITION = 50;
    private static final int DIMX = 48;
    private static final int DIMY = 48;
    private static final int NLIVES = 3;
    /**
     * Construct a Hero in game.
     */
    public Hero() {
        super(new Position(START_POSITION, START_POSITION), EntityType.HERO, new Dimension(DIMX, DIMY), NLIVES);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Collision c) {
        switch (c.getReceiver().getType()) {
        case BOMB:
            if (((Bomb) c.getReceiver()).getState() == BombState.IN_EXPLOSION) {
                lifeToRemove++;
            }
            break;
        case MONSTER:
            this.setPosition(c.getPosition());
            lifeToRemove++; 
            break;
        default:
            this.setPosition(c.getPosition());
            break;

        }
        if (lifeToRemove == 1) {
            removeLife();
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void move() {
        switch (getDirection()) {
        case IDLE:
            setVelocity(Velocity.ZERO);
            break;
        case UP:
            setVelocity(new Velocity(0, (int) (-Velocity.SPEED * velocityModifier)));
            break;
        case DOWN:
            setVelocity(new Velocity(0, (int) (Velocity.SPEED * velocityModifier)));
            break;
        case LEFT:
            setVelocity(new Velocity((int) (-Velocity.SPEED * velocityModifier), 0));
            break;
        case RIGHT:
            setVelocity(new Velocity((int) (Velocity.SPEED * velocityModifier), 0));
            break;
        default:
            break;
        }
        lifeToRemove = 0;
    }
    /**
     * Set the velocity modifier field.
     * @param modifier the new value.
     */
    public void setVelocityModifier(final Double modifier) {
        this.velocityModifier = modifier;
    }
    /**
     * Used to set if the hero has got the key.
     */
    public void setKeyFind() {
        this.gotKey = true;
    }
    /**
     * Used to know if the hero has got the key.
     * @return a boolean 
     */
    public boolean hasKey() {
        return this.gotKey;
    }
    /**
     * Method called only when the hero reach the door.
     * If he already got the key, he win the match, otherwise do nothing.
     */
    public void checkWin() {
        win = gotKey;
    }
    
    public boolean hasWon() {
        return win;
    }


}
