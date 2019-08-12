package it.unibo.bmbman.controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import it.unibo.bmbman.model.utilities.Sound;
import it.unibo.bmbman.model.utilities.SoundImpl;


/**
 * This class stores and gets any {@link Sound}.
 */
public class SoundsController {

    private Sound music;
    private Sound explosion;
    private Sound placeBomb;
    private boolean soundOn = true;

    /**
     * Creates a {@code SoundsController}.
     *
     * @throws UnsupportedAudioFileException : wrong audio file format
     * @throws IOException : problem during input/output
     * @throws LineUnavailableException : audio line can't be opened because it is unavailable
     */
    public SoundsController() {
        try {
            this.music = new SoundImpl("/music.wav");
            this.explosion = new SoundImpl("/explosion.wav");
            this.placeBomb = new SoundImpl("/placeBomb.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the music in game.
     *
     * @return music {@link Sound}
     */
    public Sound getMusicSound() {
        return this.music;
    }
    /**
     * method to used to set the music game to be played.
     */
    public void setSoundOn() {
        this.soundOn = true;
    }
    /**
     * method to used to set the music game not to be played.
     */
    public void setSoundOff() {
        this.soundOn = false;
    }
    /**
     * method to know if the music game has to start or not.
     * @return a boolean
     */
    public boolean getSoundState() {
        return this.soundOn;
    }
    /**
     * Gets the explosion sound.
     * @return explosion {@link Sound}
     */
    public Sound getExplosionSound() {
        return this.explosion;
    }
    /**
     * Gets the placedBomb sound.
     * @return placeBomb {@link Sound}
     */
    public Sound getPlaceBombSound() {
        return this.placeBomb;
    }
}
