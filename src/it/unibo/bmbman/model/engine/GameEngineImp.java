package it.unibo.bmbman.model.engine;



import it.unibo.bmbman.controller.SoundsController;
import it.unibo.bmbman.controller.game.GameController;
import it.unibo.bmbman.model.utilities.GameTimer;
/**
 * 
 * creates and manages the Game Loop. Implementing {@link GameEngine}.
 */
public class GameEngineImp extends Thread implements GameEngine {

    /**
     * Constants for FPS(frames per second).
     */
    public static final int FPS = 60;
    private static final int SECONDS = 1000;
    private static final int LAPSE = SECONDS / FPS;
    private boolean update;
    private boolean isRunning;
    private final GameController game;
    private GameTimer gameTimer;
    /**
     * set variables.
     * @param gc {@link GameController}
     */
    public GameEngineImp(final GameController gc) {
        super();
        this.update = true;
        this.isRunning = false;
        this.game = gc;
        this.gameTimer = new GameTimer();
    }
    /**
     * start thread's execution.
     */
    @Override
    public void startEngine() {
        if (!this.isRunning) {
            this.isRunning = true;
            SoundsController.getMusicSound().ifPresent(s -> s.playInLoop());
            /*
             * qui creo un nuovo campo da gioco e avvio un timer
             */
            this.gameTimer.start();
            /*manda in start il thread e cambia il nome*/
            this.setName("gameLoop");
            this.start();
        }
    }
    /**
     * stop thread's execution.
     */
    @Override
    public void stopEngine() {
        if (this.isRunning) {
            this.isRunning = false;
            SoundsController.getMusicSound().ifPresent(s -> s.stop());
            this.game.endView();
            this.gameTimer.stop();
            try {
                /* manda in join il thread*/
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Set if thread is in pause.
     * @param inPause boolean value
     */
    public void setPause(final boolean inPause) {
        this.update = !inPause;
        if (inPause) {
            this.gameTimer.stop();
            SoundsController.getMusicSound().ifPresent(s -> s.stop());
        } else {
            this.gameTimer.start();
            SoundsController.getMusicSound().ifPresent(s -> s.playInLoop());
        }
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long now;
        long deltaTime;
        while (isRunning && !this.game.isGameOver() && !this.game.hasWon()) {
            now = System.currentTimeMillis();
            deltaTime = now - lastTime;
            lastTime = now;
            if (this.update) {
                this.game.update();
            }
            deltaTime = System.currentTimeMillis() - now;
            sleepToNextFrame(deltaTime);
        }
        this.stopEngine();
    }
    private void sleepToNextFrame(final long deltaTime) {
        long sleepTime;
        long remainingToSleepTime = LAPSE - deltaTime;
        if (remainingToSleepTime < 0) {
            sleepTime = LAPSE;
        } else {
            sleepTime = remainingToSleepTime;
        }
        try {
            GameEngineImp.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
