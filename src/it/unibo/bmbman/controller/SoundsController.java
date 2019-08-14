package it.unibo.bmbman.controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import it.unibo.bmbman.model.utilities.Sound;
import it.unibo.bmbman.model.utilities.SoundImpl;


/**
 * This class stores and gets any {@link Sound}.
 */
public class SoundsController {

    private Sound music;
    private Sound explosion;
    private Sound placeBomb;
    private boolean musicOn = true;
    private boolean effectsOn = true;

    /**
     * Creates a {@code SoundsController}.
     *
     * @throws UnsupportedAudioFileException : wrong audio file format
     * @throws IOException : problem during input/output
     * @throws LineUnavailableException : audio line can't be opened because it is unavailable
     */
    public SoundsController() {
        try {
            this.music = new SoundImpl("/placeBomb.wav");
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
    public void setMusicdOn() {
        this.musicOn = true;
    }
    /**
     * method to used to set the music game not to be played.
     */
    public void setMusicOff() {
        this.musicOn = false;
    }
    /**
     * method to know if the music game has to start or not.
     * @return a boolean
     */
    public boolean getMusicState() {
        return this.musicOn;
    }
    /**
     * Method to make the effects sounds active.
     */
    public void setEffectsOn() {
        this.effectsOn = true;
    }
    /**
     * Method to disactivate effects sounds.
     */
    public void setEffectsOff() {
        this.effectsOn = false;
    }
    /**
     * Method to know if the effects sounds is activeted.
     * @return effectsOn a boolean
     */
    public boolean getEffectState() {
        return this.effectsOn;
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
