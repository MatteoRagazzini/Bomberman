package it.unibo.bmbman.view.utilities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * An implementation of {@link Animation}.
 */
public class AnimationImpl implements Animation {

    private final List<Image> animation;
    //private int frame = 0;
    private Iterator<Image> iterator;
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
//        if (frame < this.animation.size()) {
//            frame++;
//            return this.animation.get(frame - 1);
//        } else {
//            frame = 0;
//            return this.animation.get(frame);
//        }
        return this.iterator.next();

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addFrame(final Image frame) {
        this.animation.add(frame);
        setIterator();
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
        setIterator();
    }
    private void setIterator() {
        this.iterator = Stream.iterate(0, i -> (i + 1) % this.animation.size())
                .map(i -> this.animation.get(i))
                .iterator();
    }
}
