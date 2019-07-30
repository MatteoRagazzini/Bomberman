package it.unibo.bmbman.view;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * View of the options menu.
 */
public class OptionsView {
    private final MyGUIFactory gui;
    private final JFrame f;
    /**
     * Generate a base frame.
     */
    public OptionsView() {
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        loadOptionsView();
    }
    /**
     * Customize the options view frame.
     */
    private void loadOptionsView() {
        final JButton b = gui.createReturnButton(this.f);
        b.addActionListener(e -> {
            this.f.setVisible(false);
            new MainMenuView().loadMainMenuView();
        });
    }
    /**
     * Getter method.
     * @return the options view frame
     */
    public JFrame getFrame() {
        return this.f;
    }
}
