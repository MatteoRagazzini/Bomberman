package it.unibo.bmbman.controller;

/**
 * All the available choices in the options menu.
 */
public enum OptionsList {
    /**
     * Activate game sound.
     */
    SOUNDON("Sound On"),
    /**
     * Disable game sound. 
     */
    SOUNDOFF("Sound Off");

    private final String name;
    OptionsList(final String name) {
        this.name = name;
    }
    /**
     * to string method.
     * @return name associated with the option
     */
    public String toString() {
        return name;
    }
}
