package it.unibo.bmbman.model;

import it.unibo.bmbman.model.EntityType;

public class Score {

    private int score;

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    }

    @Override
    public String toString() {
        return "Score [score=" + score + "]";
    }
}

