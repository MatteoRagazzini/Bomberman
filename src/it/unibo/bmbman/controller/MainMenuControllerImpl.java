package it.unibo.bmbman.controller;
import it.unibo.bmbman.view.HelpView;
import it.unibo.bmbman.view.LeaderboardView;
import it.unibo.bmbman.view.MainMenuView;
import it.unibo.bmbman.view.OptionsView;

/**
 *the implementation of MainMenuController interface.
 *
 */
public class MainMenuControllerImpl implements MainMenuController {

    private final GameStateController gameState;
    private final OptionsMenuController opt;
    private final MainMenuView mainMenuView;
    /**
     * Construct a {@link MainMenuController}.
     * @param mainMenuView the view of main manu
     * @param opt {@link OptionMenuController}
     */
    public MainMenuControllerImpl(final MainMenuView mainMenuView, final OptionsMenuController opt) {
        super();
        this.mainMenuView = mainMenuView;
        this.opt = opt;
        this.gameState = new GameStateControllerImpl(this.opt.getSoundController());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptionSelected(final MainMenuOption optionSelected) {
        switch (optionSelected) {
        case SINGLE_PLAYER:
           gameState.goToSinglePlayerGame();
            break;
            /* da implementare i prossimi casi*/
            //        case MULTIPLAYER:
            //            break;
        case LEADERBOARD:
            final LeaderboardView lv = new LeaderboardView();
            lv.getFrame().setVisible(true);
            break;
        case SETTINGS:
            final OptionsView ov = new OptionsView(mainMenuView, opt);
            ov.getFrame().setVisible(true);
            break;
        case HELP:
            final HelpView hv = new HelpView(mainMenuView);
            hv.getFrame().setVisible(true);
            break;
        default:
            break;
        }
    }

}

