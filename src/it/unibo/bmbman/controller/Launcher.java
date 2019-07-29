package it.unibo.bmbman.controller;

import it.unibo.bmbman.view.MainMenuView;

/**
 * start the application.
 *
 */
public final class Launcher {
    private Launcher() { };
    /**
     * 
     * @param args .
     */
    public static void main(final String[] args) {
         new MainMenuView().loadMainMenuView();
    }
}
