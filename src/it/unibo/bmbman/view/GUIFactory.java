package it.unibo.bmbman.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;

/**
 * interface for abstract factory pattern.
 *
 */
public interface GUIFactory {
    /**
     * Method to generate a Button.
     * @param text the button's text
     * @return a JButton.
     */
    JButton createButton(String text);
    /**
     * Method to generate a Frame.
     * 
     * @return a JFrame.
     */
    JFrame createFrame();
    /**
     * Generate a panel and a "return to main menu" button.
     * @param frame the frame used
     * @return the button created
     */
    JButton createReturnButton(JFrame frame);
    /**
     * Method to generate a RadioButtonMenuItem.
     * @param text the button's text
     * @return the button created
     */
    JRadioButtonMenuItem createRadioButton(String text);
}
