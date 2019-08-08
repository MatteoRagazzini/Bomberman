package it.unibo.bmbman.controller;



import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.view.GameOverView;
/**
 * An implementation of {@link GameStateController}.
 *
 */

public class GameStateControllerImpl implements GameStateController {

    private final GameEngine gameEngine;
    private boolean inPause;
    /**
     * Contruct a {@link GameStateControllerImpl}.
     * @param sc {@link SoundsController}
     */
    public GameStateControllerImpl(final SoundsController sc) {
        this.gameEngine = new GameEngineImp(this, sc);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void goToSinglePlayerGame() {
        gameEngine.startEngine();
    }

    @Override
    public void goToPause() {
        inPause = !inPause;
        gameEngine.setPause(inPause);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void goToGameOver() {
        final GameOverView over = new GameOverView();
        over.getFrame().setVisible(true);
    }


}