package it.unibo.bmbman.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopBar extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel gameTime = new JLabel(GameTimer.getString());
    private JLabel score = new JLabel("score");
    
    public TopBar(JPanel nPanel) {
        this.panel = nPanel;
        this.panel.add(gameTime);
        this.panel.add(score);
    }
    
    public void render() {
        return;
    }

    public JPanel getPanel() {
        return panel;
    }

}
