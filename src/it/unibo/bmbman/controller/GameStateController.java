package it.unibo.bmbman.controller;
/**
 * Inteface to control each game state.
 */
public interface GameStateController {
    /**
     * Used to start the game in singleplayer version.
     */
    void goToSinglePlayerGame();
    /**
     * Used to pause the game.
     */
    void goToPause();
    /**
     * Used to notify the GameOver.
     */
    void goToGameOver();
}
