package it.unibo.bmbman.view.utilities;

import java.awt.Toolkit;
/**
 * Screen resolution utility class.
 */
public class ScreenTool {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WIDTH_REF = 2000;
    private static final double HEIGHT_REF = 1100;
    private static final Float NEW_SIZE = 50f;
    private final GameFont font = new GameFont();
    /**
     * Method to adjust font size based on screen resolution.
     */
    public void checkFontSize() {
        if (getScreenRes().equals("4k")) {
            font.setFontSize(NEW_SIZE);
        }
    }
    /**
     * Method to get the screen resolution.
     * @return the screen resolution
     */
    public String getScreenRes() {
        if (SCREEN_WIDTH > WIDTH_REF && SCREEN_HEIGHT > HEIGHT_REF) {
            return "4k";
        } else {
            return "HD";
        }
    }
}
