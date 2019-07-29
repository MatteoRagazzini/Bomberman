package it.unibo.bmbman.controller;
import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.view.SinglePlayerView;

/**
 *the implementation of MainMenuController interface.
 *
 */
public class MainMenuControllerImpl implements MainMenuController {
/**
 * .
 */
@Override
    public void setOptionSelected(final MainMenuOption optionSelected) {
    switch (optionSelected) {
        case SINGLE_PLAYER:
            SinglePlayerView spv = new SinglePlayerView();
            spv.getFrame().setVisible(true);
            GameEngine ge = new GameEngineImp();
            ge.startEngine();
            break;
    /* da implementare i prossimi casi*/
//        case MULTIPLAYER:
//            break;
        case LEADERBOARD:
            break;
        case SETTINGS:
            break;
        case HELP:
            break;
        default:
            break;
        }
    }
}
