package it.unibo.bmbman.controller;
/**
 * runs the main menu.
 *
 */
public interface MainMenuController {
    /**
     * The controller, according to the option selected, call the right application component.
     * @param optionSelected the option chosen in {@link MainMenuView} by the player.
     */
    void setOptionSelected(MainMenuList optionSelected);
}
