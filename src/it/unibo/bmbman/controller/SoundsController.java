package it.unibo.bmbman.controller;

import java.io.IOException;
import java.util.Optional;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import it.unibo.bmbman.model.entities.powerUp.Key;
import it.unibo.bmbman.model.utilities.Sound;
import it.unibo.bmbman.model.utilities.SoundImpl;


/**
 * This class stores and gets any {@link Sound}.
 */
public class SoundsController {

    private static Optional<Sound> music;
    private static Optional<Sound> explosion;
    private static Optional<Sound> placeBomb;
    private static Optional<Sound> key;
    private static String folder = "/Sounds";
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
            SoundsController.music = Optional.of(new SoundImpl(folder + "/music.wav"));
            SoundsController.explosion = Optional.of(new SoundImpl(folder + "/explosion.wav"));
            SoundsController.placeBomb = Optional.of(new SoundImpl(folder + "/placeBomb.wav"));
            SoundsController.key = Optional.of(new SoundImpl(folder + "/key.wav"));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the music in game.
     *
     * @return music {@link Sound}
     */
    public static Optional<Sound> getMusicSound() {
        return music;
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
     * Gets the explosion sound.
     * @return explosion {@link Sound}
     */
    public static Optional<Sound> getExplosionSound() {
        return explosion;
    }
    /**
     * Gets the placedBomb sound.
     * @return placeBomb {@link Sound}
     */
    public static Optional<Sound> getPlaceBombSound() {
        return placeBomb;
    }
    /**
     * Gets the {@link Key} sounds. 
     * @return key {@link Sound}
     */
    public static Optional<Sound> getKeySound() {
        return key;
    }
    /**
     * Method used to remove sounds if we don't want to hear them during the game.
     */
    public void setSounds() {
        if (!musicOn) {
            SoundsController.music = Optional.empty();
        }
        if (!effectsOn) {
            SoundsController.explosion = Optional.empty();
            SoundsController.placeBomb = Optional.empty();
            SoundsController.key = Optional.empty();
        }
    }
}

