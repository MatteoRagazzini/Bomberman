package it.unibo.bmbman.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
/**
 * Frame for game over.
 */
public class GameOverView {

    private final GUIFactory guiFactory = new MyGUIFactory();
    private final JFrame frame = guiFactory.createFrame();

    public GameOverView() {
        this.frame.getContentPane().setBackground(Color.BLACK);
        this.frame.getContentPane().setLayout(new FlowLayout());
        this.frame.getContentPane().add(guiFactory.createLabel("GAME OVER"));
    }

    public JFrame getFrame() {
        return this.frame;
    }


}
