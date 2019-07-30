package it.unibo.bmbman.model.engine;

import it.unibo.bmbman.view.SinglePlayerView;

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
    SinglePlayerView spv = new SinglePlayerView();
    /*private final Handler handler;cambiare nome e tipo poi*/
    /*private final int modality; intero che indica multiplayer o single player*/
    /**
     * set variables.
     */
    public GameEngineImp(/*sicuro passerò la modalità di gioco, single o multiplayer, e un handler*/) {
        super();
        this.update = true;
        this.isRunning = false;
        /*this.modality=1; ci andrà quella presa in input*/
        /*this.handler=handler;*/
    }
    /**
     * start thread's execution.
     */
    @Override
    public void startEngine() {
        if (!this.isRunning) {
            this.isRunning = true;
            /*
             * qui creo un nuovo campo da gioco e avvio un timer
             */
            spv.getFrame().setVisible(true);
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
            /*
             * chiamerò un metodo tipo freeze(); su tutto e bloccherà ogni oggetto.
             *
             */
            try {
                /* manda in join il thread*/
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        while (isRunning) {
            now = System.currentTimeMillis();
            deltaTime = now - lastTime;
            lastTime = now;
            if (this.update) {
                /*viene chiamato anche il metodo che legge in input*/
                /*controller.upadte(); che mi va ad aggiornare tutti gli oggetti e tutte le grafiche che
                 * chiamerà lui per questo qua non metto render*/
                /*togliere anche questa stampa*/
                spv.render();
                System.out.println("update" + now);
                /*togliere*/
            }
            deltaTime = System.currentTimeMillis() - now;
            sleepToNextFrame(deltaTime);
            System.out.println("sveglio");
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
            System.out.println("dormirò" + sleepTime);
            /*manda in sleep il thread*/
            GameEngineImp.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
