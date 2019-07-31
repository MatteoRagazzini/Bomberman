package it.unibo.bmbman.view.utilities;

import java.awt.Toolkit;
/**
 * Screen resolution utility class.
 */
public class ScreenTool {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WIDTH_REF_WQHD = 3500;
    private static final double HEIGHT_REF_WQHD = 2000;
    private static final double WIDTH_REF_HD = 1500;
    private static final double HEIGHT_REF_HD = 900;
    private static final double WIDTH_REF_QHD = 2200;
    private static final double HEIGHT_REF_QHD = 1200;
    private final String ris;
    /**
     * Get the screen resolution and save it.
     */
    public ScreenTool() {
        ris = getScreenRes();
    }
    /**
     * Method to get the screen resolution.
     * @return the screen resolution
     */
    private static String getScreenRes() {
        if (SCREEN_WIDTH > WIDTH_REF_WQHD && SCREEN_HEIGHT > HEIGHT_REF_WQHD) {
            return "WQHD";
        } else if (SCREEN_WIDTH < WIDTH_REF_HD && SCREEN_HEIGHT < HEIGHT_REF_HD) {
            return "HD";
        } else if (SCREEN_WIDTH > WIDTH_REF_QHD && SCREEN_HEIGHT > HEIGHT_REF_QHD) {
            return "QHD";
        } else {
            return "FHD";
        }
    }
    /**
     * Getter for resolution type.
     * @return the resolution
     */
    public String getRis() {
        return this.ris;
    }
}