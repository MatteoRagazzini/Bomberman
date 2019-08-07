package it.unibo.bmbman.controller;

/**
 * All the available choices in the options menu.
 */
public enum OptionsMenuList {
    /**
     * Activate game sound.
     */
    SOUNDON("ON"),
    /**
     * Disable game sound. 
     */
    SOUNDOFF("OFF");

    private final String name;
    OptionsMenuList(final String name) {
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
