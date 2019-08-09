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
    private int bombNumber;
    private boolean gotKey = false;
    private static final int START_POSITION = 50;
    /**
     * Construct a Hero in game.
     * @param gc the game controller
     */
    public Hero(final GameController gc) {
        super(new Position(START_POSITION, START_POSITION), EntityType.HERO, new Dimension(45, 48), 3);
        this.gc = gc;
        this.bombNumber = 1;
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
    /**
     * Used to know how many bombs the hero can plant.
     * @return the number of bombs
     */
    public int getBombNumber() {
        return this.bombNumber;
    }
    /**
     * Used to add a bomb to hero stock.
     */
    public void incrementBombNumber() {
        this.bombNumber++;
    }
    /**
     * Used to set if the hero has got the key.
     */
    public void setKeyFind() {
        this.gotKey = true;
    }
    /**
     * Method called only when the hero reach the door.
     * If he already got the key, he win the match, otherwise do nothing.
     */
    public void checkWin() {
        if (this.gotKey) {

        }
    }
}
