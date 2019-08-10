package it.unibo.bmbman.controller;

import java.util.List;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Score;

/**
 *
 */
public class Scoring {
    private enum ScoreValue {
        BONUS (50),
        MALUS (-50),
        MONSTER (100),
        //LIFE_REMOVED (-200),
        DOOR (200);

    private final int value;
    
    private ScoreValue (final int value) {
        this.value = value;
    }
    
    public static int getValue(Entity e) {
        if (e.toString().startsWith("Bonus")) {
            return BONUS.value;
        } else if (e.toString().startsWith("Malus")) {
            return MALUS.value;
        } else if (e.toString().equals("Door")) {
            return DOOR.value;
        } else if (e.getType().equals(EntityType.MONSTER)) {
            return MONSTER.value;
        }
        return 0;
    }
}
    private Score score;
    public Scoring() {
        this.score = new Score();
    }

    public void setValue(List<Entity> entityToRemoved) {
        entityToRemoved.stream().forEach(e -> {
            if(ScoreValue.getValue(e) != 0) {
                this.score.setScore(ScoreValue.getValue(e));
                System.out.println(this.score);
            }
        });
    }
}
