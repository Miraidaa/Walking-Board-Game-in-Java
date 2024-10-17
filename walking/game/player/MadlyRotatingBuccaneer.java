package walking.game.player;

import walking.game.util.Direction;

public class MadlyRotatingBuccaneer extends Player {
    @Override
    public void turn() {
        direction = Direction.values()[(direction.ordinal() + turnCount) % Direction.values().length];
        turnCount++;
    }
}




