package it.unibo.bmbman.controller;

import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.view.GameOverView;
import it.unibo.bmbman.view.GameTimer;
/**
 * An implementation of {@link GameStateController}.
 *
 */

public class GameStateControllerImpl implements GameStateController {

    private final GameEngine gameEngine = new GameEngineImp(this);
    private boolean inPause;


    /**
     * {@inheritDoc}
     */
    @Override
    public void goToSinglePlayerGame() {
        gameEngine.startEngine();
    }

    @Override
    public void goToPause() {
    }

    @Override
    public void goToGameOver() {
        final GameOverView over = new GameOverView();
        over.getFrame().setVisible(true);
    }


}
