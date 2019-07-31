package it.unibo.bmbman.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import it.unibo.bmbman.controller.OptionsList;

/**
 * View of the options menu.
 */
public class OptionsView {

// private final Map<JButton, OptionsList > jbMap = new HashMap<>();
// private final OptionsMenuController omc = new OptionMenuControllerImpl();
 private JPanel centerP; 
 private GridBagConstraints c;
 private JFrame f;
 private final MyGUIFactory gui;

    /**
     * Create options menu view.
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
        f.setTitle("BOMBERMAN - Options Menu");
        f.setBackground(Color.black);
        loadPanels();
        loadButtons();
    }

    private void loadPanels() {
        centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(Color.black);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        //magic number da cambiare in caso di 4k
        c.insets = new Insets(25, 60, 35, 20); 
        f.add(centerP, BorderLayout.CENTER);
    }

    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            new MainMenuView().loadMainMenuView();
        });
        final JRadioButtonMenuItem musicB = gui.createRadioButton(OptionsList.values()[0].toString());
        c.gridx = 0;
        c.gridy = 1; //voglio che vengano messi uno sotto all'altro 
        centerP.add(musicB, c);
//        jbMap.put(musicB, OptionsList.values()[0]);
    }
    /**
     * Getter method.
     * @return the options view frame
     */
    public JFrame getFrame() {
        return this.f;
    }
}
