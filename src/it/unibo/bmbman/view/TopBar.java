package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.bmbman.controller.Scoring;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.utilities.PlayerScore;
import it.unibo.bmbman.view.utilities.GameFont;

public class TopBar extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //private JPanel panel;
    private JLabel gameTime = new JLabel();
    private JLabel score = new JLabel();
    private JLabel lives = new JLabel();
    private Hero hero;
    private PlayerScore ps;
    /**
     * 
     * @param nPanel 
     * @param ps 
     * @param hero 
     */
    public TopBar(final PlayerScore ps, final Hero hero) {
        final GameFont font = new GameFont();
        this.setLayout(new GridLayout(1, 3));
        this.gameTime.setFont(font.getFont());
        this.score.setFont(font.getFont());
        this.lives.setFont(font.getFont());
        this.add(gameTime);
        this.add(score);
        this.add(lives);
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
    }
    /**
     * 
     * @return panel
     */
    public JPanel getPanel() {
        return this;
    }

}
