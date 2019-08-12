package it.unibo.bmbman.controller;



import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.view.GameOverView;
import it.unibo.bmbman.view.MainMenuView;
/**
 * An implementation of {@link GameStateController}.
 *
 */

public class GameStateControllerImpl implements GameStateController {

    private final GameEngine gameEngine;
    private boolean inPause;
    private MainMenuView mainView; 
    /**
     * Contruct a {@link GameStateControllerImpl}.
     * @param sc {@link SoundsController}
     * @param mainMenuView the current {@link MainMenuView}
     */
    public GameStateControllerImpl(final SoundsController sc, final MainMenuView mainMenuView) {
        this.gameEngine = new GameEngineImp(this, sc);
        this.mainView = mainMenuView;
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
        final GameOverView over = new GameOverView(mainView);
        over.getFrame().setVisible(true);
    }


}