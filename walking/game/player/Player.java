package walking.game.player;

import walking.game.util.Direction;

public class Player {
    private int score;
    protected Direction direction = Direction.UP;
    protected int turnCount = 0;

    public Player() {}

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public Direction getDirection() {
        return direction;
    }

    public void turn() {
        direction = Direction.values()[(direction.ordinal() + 1) % Direction.values().length];
        turnCount++;
    }


    
}


