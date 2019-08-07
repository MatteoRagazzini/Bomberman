package it.unibo.bmbman.model;


import it.unibo.bmbman.controller.GameController;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.model.utilities.Velocity;
/**
 * Representing a hero in our application.
 */
public class Hero extends AbstractLivingEntity {
    private Double velocityModifier = 1.0;
    private final GameController gc;
    private static final int START_POSITION = 50;
    /**
     * Construct a Hero in game.
     * @param gc the game controller
     */
    public Hero(final GameController gc) {
        super(new Position(START_POSITION, START_POSITION), EntityType.HERO, new Dimension(45, 48), 3);
        this.gc = gc;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        this.setPosition(newPosition);
        this.setDirection(Direction.IDLE);
        System.out.println("Eroe colliso con" + receiver.getType());
        if (receiver.getType() == EntityType.MONSTER) {
            this.removeLife();
        } else if (receiver.getType() == EntityType.POWER_UP) {
            gc.removeEntity(receiver);
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
        update();
    }
    /**
     * Set the velocity modifier field.
     * @param modifier the new value.
     */
    public void setVelocityModifier(final Double modifier) {
        this.velocityModifier = modifier;
    }
    @Override
    protected void reachedBorder() {

    }

}
