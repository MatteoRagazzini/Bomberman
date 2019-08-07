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
    private boolean SoundOn = true;

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
    
    public void setSoundOn() {
        this.SoundOn = true;
    }
    public void setSoundOff() {
        this.SoundOn = false;
    }
    public boolean getSoundState() {
        return this.SoundOn;
    }
}