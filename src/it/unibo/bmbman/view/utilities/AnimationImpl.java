package it.unibo.bmbman.view.utilities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * An implementation of {@link Animation}.
 */
public class AnimationImpl implements Animation {

    private final List<Image> animation;
    private Iterator<Image> it;
    /**
     * Construct {@link Animation}.
     */
    public AnimationImpl() {
        this.animation = new ArrayList<>();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Image> getImageAt(final int index) {
        return index < this.animation.size() ? Optional.of(this.animation.get(index)) : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Image getNextImage() {
        if (it.hasNext()) {
            return it.next();
        } else {
            it = this.animation.iterator();
            return it.next();
        }

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addFrame(final Image frame) {
        this.animation.add(frame);
        it = this.animation.iterator();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void createAnimation(final String path, final int frame, final int dimension) {
        final SpriteSheet ss = new SpriteSheet(path);
        for (int i = 1; i <= frame; i++) {
            this.animation.add(new Sprite(ss, i, 1, dimension).getBufferedImage());
        }
        it = this.animation.iterator();
    }
}
