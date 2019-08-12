package it.unibo.bmbman.controller;

/**
 * All the available choices in the options menu.
 */
public enum OptionsMenuList {
    /**
     * Activate game sound.
     */
    MUSICON("ON"),
    /**
     * Disable game sound. 
     */
    MUSICOFF("OFF"),
    /**
     * Activate game sound.
     */
    EFFECTON("ON"),
    /**
     * Disable game sound. 
     */
    EFFECTOFF("OFF");

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
