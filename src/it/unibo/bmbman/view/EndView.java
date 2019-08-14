package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.bmbman.controller.EndGameState;
import it.unibo.bmbman.controller.game.GameController;
import it.unibo.bmbman.model.leaderboard.PlayerScore;
import it.unibo.bmbman.model.leaderboard.ScoreHandler;
import it.unibo.bmbman.model.utilities.GameTimer;
import it.unibo.bmbman.view.utilities.BackgroundPanel;
import it.unibo.bmbman.view.utilities.ScreenTool;
/** 
 * Frame for game over.
 */
public class EndView {

    private MyGUIFactory gui;
    private final MainMenuView mainView;
    private JFrame f;
    private JPanel centerP; 
    private JPanel backgroundP;
    private JPanel northP;
    private JButton enterName;
    private JButton nextLevel;
    private JTextField nameTextField;
    private String gameOverImagePath;
    private Image image;
    private GridBagConstraints c;
    private int score;
    private final GameController gameController;
    private final EndGameState state;
    private final PlayerScore ps;
    private static final Insets INSETS = new Insets(50, 25, 50, 25);
    /**
     * 
     * @param mainMenuView 
     * @param state 
     * @param gameController 
     */
    public EndView(final MainMenuView mainMenuView, final EndGameState state, final GameController gameController, final PlayerScore ps) {
        mainView = mainMenuView;
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        this.state = state;
        this.gameController = gameController;
        this.ps = ps;
        this.score = ps.getScore();
        loadEndView();
    }

    /**
     * Customize the GameOverView view frame.
     */
    private void loadEndView() {
        switch (state) {
            case LOSE:
                f.setTitle("BOMBERMAN - GameOver");
                break;
            case WIN:
                f.setTitle("BOMBERMAN - You WIN!");
                break;
            default:
                break;
        }
        f.setBackground(Color.black);
        saveGameOverImagePath();
        loadPanels();
        loadLabels();
        loadTextField();
        loadButtons();
    }

    /**
     * Used to loadLabels.
     */
    private void loadLabels() {
        JLabel titleLabel = gui.createLabel("");
        switch (state) {
            case LOSE:
                titleLabel = gui.createLabel("Game Over");
                break;
            case WIN:
                titleLabel = gui.createLabel("YOU WIN!");
                break;
            default:
                break;
        }
        final JLabel timeLabel = gui.createLabel("Game Time");
        final JLabel playerTimeLabel = gui.createLabel(GameTimer.getString());
        final JLabel scoreLabel = gui.createLabel("Score");
        final JLabel playerScoreLabel = gui.createLabel(String.valueOf(this.score));
        final JLabel enterYourName = gui.createLabel("Enter your name");
        northP.add(titleLabel, BorderLayout.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        centerP.add(timeLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        centerP.add(playerTimeLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        centerP.add(scoreLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        centerP.add(playerScoreLabel, c);
        c.gridx = 0;
        c.gridy = 2;
        centerP.add(enterYourName, c);
    }
    /**
     * Used to load Panels.
     */
    private void loadPanels() {
        backgroundP = new BackgroundPanel(loadImage(gameOverImagePath));
        backgroundP.setBackground(Color.BLACK);
        centerP = new JPanel(new GridBagLayout());
        centerP.setOpaque(false);
        northP = new JPanel();
        northP.setBackground(Color.BLACK);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0;
        c.insets = gui.createScaledInsets(INSETS);
        backgroundP.setLayout(new BorderLayout());
        backgroundP.add(centerP, BorderLayout.WEST);
        f.add(backgroundP, BorderLayout.CENTER);
        f.add(northP, BorderLayout.NORTH);
    }
    /**
     * Used to load buttons.
     */
    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            mainView.getFrame().setVisible(true);
        });
        enterName = gui.createButton("Save");
        enterName.setBorderPainted(true);
        enterName.addActionListener(e -> {
            ScoreHandler.checkAndReadWrite(this.gameController.getLevel().getLevel(), ps, nameTextField.getText(), GameTimer.getString());
            enterName.setEnabled(false);
        });
        c.gridx = 1;
        c.gridy = 3;
        centerP.add(enterName, c);
        if (this.state == EndGameState.WIN) {
            nextLevel = gui.createButton("Go to next level");
            nextLevel.setBorderPainted(true);
            nextLevel.setBackground(Color.darkGray);
            nextLevel.addActionListener(e -> {
                gameController.getLevel().levelUp();
                gameController.startGame();
                this.getFrame().setVisible(false);
            });
            c.gridx = 2;
            c.gridy = 3;
            centerP.add(nextLevel, c);
        }
    }
    /**
     * Used to load JTextField. 
     */
    private void loadTextField() {
        this.nameTextField = gui.createTextField();
        c.gridx = 0;
        c.gridy = 3;
        centerP.add(nameTextField, c);
        nameTextField.addKeyListener(new KeyAdapter() {
        public void keyReleased(final KeyEvent event) {
            String content = nameTextField.getText();
                if (!content.equals("")) {
                    enterName.setEnabled(true);
                } else {
                    enterName.setEnabled(false);
                }
            }
        });
    }
    /**
     * Used to get the actual frame.
     * @return frame 
     */
    public JFrame getFrame() {
        return this.f;
    }
    /**
     * Used to save the appropriete image according to screen resolution.
     */
    private void saveGameOverImagePath() {
        gameOverImagePath = "/image/" + ScreenTool.getScreenRes() + "_GameOverImage.png";
    }

    private Image loadImage(final String text) {
        try {
            image = ImageIO.read(getClass().getResource(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
