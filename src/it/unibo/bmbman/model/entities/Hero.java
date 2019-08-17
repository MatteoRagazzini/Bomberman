package it.unibo.bmbman.model.entities;
/**
 *Inteface to model the hero in our game.
 */
public interface Hero {
    /**
     * Used to set that Hero has pick up the key.
     */
    void setKey();
    /**
     * Used to know if hero has already pick up the key.
     * @return true if the hero has the key
     */
    boolean hasKey();
    /**
     * Used to check if hero has the key and he is in door position.
     */
    void checkWin();
    /**
     * Used to know if the hero has won.
     * @return true if he has the key and he is in {@link Door} position
     */
    boolean hasWon();
}
