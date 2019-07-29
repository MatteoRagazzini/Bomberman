package it.unibo.bmbman.controller;

/**
 * Main menu possible choices, when the application start.
 * 
 */
public enum MainMenuOption {
    /**
     * Classic game mode with one player VS CPU.
    */
    SINGLE_PLAYER("Single player"),
    /**
     * Score board based on time to complete each level.
     */
    LEADERBOARD("Leaderboard"),
    /**
     * Settings option menu.
     */
    SETTINGS("Settings"),
    /**
     * tips and more.
     */
    HELP("Helps");
//    /**
//     * Game mode: player VS player.
//     */
//    MULTIPLAYER;
    private final String name;
    /**
     * Construct a {@code MainMenuOption}.
     * @param name of main menu option
     */
    MainMenuOption(final String name) {
        this.name = name;
    }
}
