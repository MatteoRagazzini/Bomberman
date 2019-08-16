package it.unibo.bmbman.view.utilities;

import java.awt.Image;
import java.util.Optional;

/**
 * Used to model the concept of Animation in our game.
 */
public interface Animation {
    /**
     * Create an {@link Animation} from path of an image that has just one row of frame.
     * @param path path for image
     * @param frame number of frame for this {@link Animation}
     * @param dimension dimension of each frame
     */
    void createAnimation(String path, int frame, int dimension);
    /**
     * Add a frame to the squence of {@link Animation}.
     * @param frame the {@link Image} to add
     */
    void addFrame(Image frame);
    /**
     * Used to get a specific image of the animation.
     * @param index the index of the image
     * @return an {@link Image}
     */
    Optional<Image> getImageAt(int index);
    /**
     * Used to get the next image of animation.
     * @return {@link Image}
     */
    Image getNextImage();
}
