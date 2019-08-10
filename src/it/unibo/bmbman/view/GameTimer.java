package it.unibo.bmbman.view;

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
     * @param label2 
     */
    public GameTimer(/*JLabel label2*/) {
        super(DELAY, a -> {
            seconds++;
            if(seconds == SECONDS_IN_MINUTE) {
                minutes++;
                seconds = 0;
            }
            //label2.setText(String.format("%02d:%02d", minutes, seconds));
            //System.out.println(String.format("%02d:%02d", minutes, seconds));
        }); 
    }
    /**
     * 
     * @return totSec
     */
    public static int getTotSeconds() {
        return seconds + (minutes * SECONDS_IN_MINUTE);
    } 
    /**
     * 
     * @return string
     */
    public static String getString() {
        return String.format("%02d:%02d", minutes, seconds);
    }
}

