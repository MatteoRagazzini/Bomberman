package it.unibo.bmbman.view.utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class to load an image from res folder.
 */
public class ImageLoader {
    private BufferedImage image;
    /**
     * Load an image and return it.
     * @param text the image path
     * @return the buffered image
     */
    public BufferedImage loadImage(final String text) {
        try {
            image = ImageIO.read(getClass().getResource(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
