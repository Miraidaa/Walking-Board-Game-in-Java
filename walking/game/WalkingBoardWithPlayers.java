package walking.game;

import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;

public class WalkingBoardWithPlayers extends WalkingBoard {
    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount){
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount){
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {
        if (playerCount < 2) {
            throw new IllegalArgumentException("Number of players must be at least 2");
        }
        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    

    public int[] walk(int... stepCounts) {
        int[] scores = new int[players.length];
        for (int i = 0; i < stepCounts.length; i++) {
            for (int j = 0; j < players.length; j++) {
                Player currentPlayer = players[j];
                currentPlayer.turn();
                for (int k = 0; k < stepCounts[i]; k++) {
                    int steps = Math.min(k, SCORE_EACH_STEP);
                    moveAndSet(currentPlayer.getDirection(), steps);
                    currentPlayer.addToScore(valueFromBoard());
                    scores[j] = currentPlayer.getScore();
                }
            }
            round++;
        }
        return scores;
    }
    

    private int valueFromBoard() {
        int[] position = getPosition();
        int[][] tiles = getTiles();
        return tiles[position[0]][position[1]];
    }
    
}
