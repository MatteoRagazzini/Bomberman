package it.unibo.bmbman.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import it.unibo.bmbman.controller.OptionsMenuList;
import it.unibo.bmbman.controller.OptionsMenuController;
import it.unibo.bmbman.view.utilities.ImageLoader;
import it.unibo.bmbman.view.utilities.ScreenTool;


/**
 * View of the options menu.
 */
public class OptionsView {

    private final Map<JRadioButton, OptionsMenuList> jbMap = new HashMap<>();
    private final OptionsMenuController optionsMenuCtrl;
    private final MainMenuView mainView;
    private final ScreenTool st = new ScreenTool();
    private static Insets insets;
    private String optionsImagePath;
    private JPanel centerP; 
    private JPanel eastP;
    private JPanel northP;
    private GridBagConstraints c;
    private JFrame f;
    private final MyGUIFactory gui;
    private final ImageLoader il = new ImageLoader();

    /**
     * Create options menu view.
     * @param mainMenuView the {@link MainMenuView} with which is related
     * @param optionsMenuController the {@link OptionsMenuController} that manage all the choises
     */
    public OptionsView(final MainMenuView mainMenuView, final OptionsMenuController optionsMenuController) {
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        loadOptionsView();
        mainView = mainMenuView;
        this.optionsMenuCtrl = optionsMenuController;
    }

    /**
     * Customize the options view frame.
     */
    private void loadOptionsView() {
        f.setTitle("BOMBERMAN - Options Menu");
        f.setBackground(Color.black);
        saveOptionsImagePath();
        loadPanels();
        loadLabels();
        loadButtons();
    }

    /**
     * Used to loadLabels.
     */
    private void loadLabels() {
        // for (int i = 0; i < OptionsList.values().length; i++) {
        final JLabel musicLabel = gui.createLabel("Music");
        final JLabel titleLabel = gui.createLabel("Options Menù");
        final JLabel iconLabel = new JLabel(new ImageIcon(il.loadImage(optionsImagePath)));
        northP.add(titleLabel, BorderLayout.CENTER);
        eastP.add(iconLabel, BorderLayout.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        centerP.add(musicLabel, c);
        // }
    }

    /**
     * Used to load panels.
     */
    private void loadPanels() {
        centerP = new JPanel(new GridBagLayout());
        eastP = new JPanel(new BorderLayout());
        northP = new JPanel();
        centerP.setBackground(Color.black);
        eastP.setBackground(Color.BLACK);
        northP.setBackground(Color.BLACK);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 3.0;
        c.insets = this.insets;
        f.add(centerP, BorderLayout.CENTER);
        f.add(eastP, BorderLayout.EAST);
        f.add(northP, BorderLayout.NORTH);
    }

    /**
     * Used to load buttons.
     */
    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            this.mainView.getFrame().setVisible(true);
        });
        final ButtonGroup music = new ButtonGroup();
        for (int i = 0; i < OptionsMenuList.values().length; i++) {
            final JRadioButton b = gui.createRadioButton(OptionsMenuList.values()[i].toString());
            b.addActionListener(e -> {
                final JRadioButton jb = (JRadioButton) e.getSource();
                optionsMenuCtrl.setOptionSelected((jbMap.get(jb)));
            });
            if (b.getText().equals("ON")) {
                b.setSelected(true);
            }
            c.weightx = 0; //mi serve per spostare i tasti on e off in fondo
            c.gridx = i + 1;
            c.gridy = 0; 
            music.add(b);
            centerP.add(b, c);
            jbMap.put(b, OptionsMenuList.values()[i]);
        }
    }
    /**
     * Getter method.
     * @return the options view frame
     */
    public JFrame getFrame() {
        return this.f;
    }
/**
 * 
 * @param insets
 */
    public static void setInsets(final Insets insets) {
        OptionsView.insets = insets;
    }
    
    private void saveOptionsImagePath() {
        optionsImagePath = "/image/" + st.getRis() + "_OptionsImage.png";
    }
}
