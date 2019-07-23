package it.unibo.bmbman.controller;

/**
 * Main menu possible choices, when the application start.
 * 
 */
public enum MainMenuOption {
    /**
     * Classic game mode with one player VS CPU.
    */
    SINGLE_PLAYER,
    /**
     * Score board based on time to complete each level.
     */
    LEADERBOARD,
    /**
     * Settings option menu.
     */
    SETTINGS,
    /**
     * tips and more.
     */
    HELP,
    /**
     * Game mode: player VS player.
     */
    MULTIPLAYER;
}
