package it.unibo.bmbman.controller;

import javax.swing.JButton;

import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.view.GameTimer;
import it.unibo.bmbman.view.HelpView;
import it.unibo.bmbman.view.LeaderboardView;
import it.unibo.bmbman.view.OptionsView;

/**
 *the implementation of MainMenuController interface.
 *
 */
public class MainMenuControllerImpl implements MainMenuController {
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptionSelected(final MainMenuOption optionSelected) {
        switch (optionSelected) {
        case SINGLE_PLAYER:
            //commentate per testare il collider
            //            final SinglePlayerView spv = new SinglePlayerView();
            //            spv.getFrame().setVisible(true);
            final GameEngine ge = new GameEngineImp();
            ge.startEngine();
            final GameTimer g = new GameTimer();
            g.start();
            break;
            /* da implementare i prossimi casi*/
            //        case MULTIPLAYER:
            //            break;
        case LEADERBOARD:
            final LeaderboardView lv = new LeaderboardView();
            lv.getFrame().setVisible(true);
            break;
        case SETTINGS:
            final OptionsView ov = new OptionsView();
            ov.getFrame().setVisible(true);
            break;
        case HELP:
            final HelpView hv = new HelpView();
            hv.getFrame().setVisible(true);
            break;
        default:
            break;
        }
    }
}
