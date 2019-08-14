package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.leaderboard.PlayerScore;
import it.unibo.bmbman.model.leaderboard.Scoring;
import it.unibo.bmbman.model.utilities.GameTimer;
import it.unibo.bmbman.view.utilities.GameFont;
import it.unibo.bmbman.view.utilities.ImageLoader;

public class TopBar extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //private JPanel panel;
    private JLabel gameTime;
    private JLabel score;
    private JLabel lives;
    private JLabel heart;
    private JLabel key;
    private Hero hero;
    private boolean keyloaded = false;
    private PlayerScore ps;
    private ImageLoader il = new ImageLoader();
    private GridBagConstraints c = new GridBagConstraints();
    /**
     * 
     * @param gui 
     * @param ps 
     * @param hero 
     */
    public TopBar(final GUIFactory gui, final PlayerScore ps, final Hero hero) {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        gameTime = gui.createLabel("");
        score = gui.createLabel("");
        lives = gui.createLabel("");
        heart = new JLabel((new ImageIcon(il.loadImage("/powerups/+life.png"))));
        this.add(heart, c);
        c.insets = new Insets(0, 0, 0, 0);
        this.add(lives, c);
        c.insets = new Insets(0, 100, 0, 0);
        this.add(score, c);
        gameTime.setPreferredSize(new Dimension(35, 0));
        this.add(gameTime, c);
        this.hero = hero;
        this.ps = ps;
    }
    /**
     * 
     */
    public void render() {
        this.gameTime.setText(GameTimer.getString());
        this.score.setText(String.valueOf(this.ps.getScore()));
        this.lives.setText(String.valueOf(hero.getLives()));
        if (hero.hasKey() && !keyloaded) {
            keyloaded = true;
            key = new JLabel((new ImageIcon(il.loadImage("/powerups/key.png"))));
            this.add(key, c);
        }
    }
    /**
     * 
     * @return panel
     */
    public JPanel getPanel() {
        return this;
    }

}
