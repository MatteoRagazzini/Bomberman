package it.unibo.bmbman.model.utilities;

import javax.swing.Timer;
/**
 * 
 * It displays game time.
 *
 */
public class GameTimer extends Timer {
    private static final long serialVersionUID = 1L;
    private static final int DELAY = 1000;
    private static final int SECONDS_IN_MINUTE = 60;
    private static int seconds;
    private static int minutes;
    {
        seconds = 0;
        minutes = 0;
    }
    /**
     * Create GameTimer.
     */
    public GameTimer() {
        super(DELAY, a -> {
            seconds++;
            if (seconds == SECONDS_IN_MINUTE) {
                minutes++;
                seconds = 0;
            }
        }); 
        System.out.println("Nuovo timer");
    }
    /**
     * 
     * @return string
     */
    public static String getString() {
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    public static int getSeconds() {
        return seconds;
    }
    
    public static int getMinutes() {
        return minutes;
    }
}

