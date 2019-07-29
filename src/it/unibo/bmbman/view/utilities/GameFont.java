package it.unibo.bmbman.view.utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * Class to load the game font.
 *
 */
public class GameFont {

    private static final String FONT_URL = "/SecretAgent.ttf";
    private static final Float FONT_SIZE = 30f;
    private Font font;
    /**
     * Create a new font from a resource file.
     */
    public GameFont() {
        final InputStream is = this.getClass().getResourceAsStream(FONT_URL);
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(FONT_SIZE);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Getter method.
     * @return the font
     */
    public Font getFont() {
        return this.font;
    }
}