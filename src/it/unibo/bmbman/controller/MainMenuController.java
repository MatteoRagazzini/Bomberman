package it.unibo.bmbman.controller;
/**
 * runs the main menu.
 *
 */
public interface MainMenuController {
    /**
     * the controller, according to the option selected, call the right game component.
     * 
     * @param optionSelected the option chosen in {@link MainMenuView} by the player.
     */
    void setOptionSelected(MainMenuOption optionSelected);
}
