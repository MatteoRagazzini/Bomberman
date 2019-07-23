package it.unibo.bmbman.controller;

import it.unibo.bmbman.view.MainMenuView;

/**
 * start the application.
 *
 */
public class Launcher {
    private Launcher() { };
    /**
     * 
     * @param args .
     */
    public static void main(final String[] args) {
         MainMenuView mainMenu = new MainMenuView();
         mainMenu.loadMainMenuView();
    }
}
