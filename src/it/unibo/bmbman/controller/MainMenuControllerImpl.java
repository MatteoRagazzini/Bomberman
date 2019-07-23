package it.unibo.bmbman.controller;
import it.unibo.bmbman.engine.GameEngine;
import it.unibo.bmbman.engine.GameEngineImp;

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
        GameEngine ge = new GameEngineImp();
        ge.startEngine();
            break;
    /* da implementare i prossimi casi*/
        case MULTIPLAYER:
            break;
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
