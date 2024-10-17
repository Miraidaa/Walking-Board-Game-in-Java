package walking.game;
import walking.game.util.Direction;
import java.util.Map;
import java.util.HashMap;

public class WalkingBoard {
   private int[][] tiles; 
   private int x; 
   private int y; 
   public static final int BASE_TILE_SCORE = 3; 
  
   public WalkingBoard(int size) {
       tiles = new int[size][size];
       for (int i = 0; i < size; i++) {
           for (int j = 0; j < size; j++) {
               tiles[i][j] = BASE_TILE_SCORE;
           }
       }
   }

   public WalkingBoard(int[][] tiles) {
    this.tiles = new int[tiles.length][];
    for (int i = 0; i < tiles.length; i++) {
        this.tiles[i] = new int[tiles[i].length];
        for (int j = 0; j < tiles[i].length; j++) {
            this.tiles[i][j] = Math.max(BASE_TILE_SCORE, tiles[i][j]);
        }
    }
}


   public int[][] getTiles() {
    int[][] copy = new int[tiles.length][];
    for (int i = 0; i < tiles.length; i++) {
        copy[i] = new int[tiles[i].length];
        for (int j = 0; j < tiles[i].length; j++) {
            copy[i][j] = tiles[i][j];
        }
    }
    return copy;
}

   
   public int[] getPosition() {
       return new int[]{x, y};
   }

   public boolean isValidPosition(int x, int y) {
       int boardSize = tiles.length; 
       return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
   }

   public int getTile(int x, int y) {
       if (isValidPosition(x, y)) {
           return tiles[x][y];
       } else {
           throw new IllegalArgumentException("Invalid position: (" + x + ", " + y + ")");
       }
   }

   private static final Map<Direction, Integer> xSteps = new HashMap<>();
    private static final Map<Direction, Integer> ySteps = new HashMap<>();

    static {
        xSteps.put(Direction.LEFT, -1);
        xSteps.put(Direction.RIGHT, 1);
        xSteps.put(Direction.UP, 0);
        xSteps.put(Direction.DOWN, 0);

        ySteps.put(Direction.LEFT, 0);
        ySteps.put(Direction.RIGHT, 0);
        ySteps.put(Direction.UP, -1);
        ySteps.put(Direction.DOWN, 1);
    }

    public static int getXStep(Direction direction) {
        return xSteps.getOrDefault(direction, 0);
    }

    public static int getYStep(Direction direction) {
        return ySteps.getOrDefault(direction, 0);
    }

   /*public static int getXStep(Direction direction) {
       switch (direction) {
           case LEFT:
               return -1;
           case RIGHT:
               return 1;
           default:
               return 0;
       }
   }

   public static int getYStep(Direction direction) {
       switch (direction) {
           case UP:
               return -1;
           case DOWN:
               return 1;
           default:
               return 0;
       }
   } */
   

   public int moveAndSet(Direction direction, int value) {
    int X = x + getXStep(direction);
    int Y = y + getYStep(direction);

    if (isValidPosition(X, Y)) {
        int previousValue = tiles[X][Y];
        tiles[X][Y] = value;
        tiles[x][y] = 0; 
        x = X;
        y = Y;
        return previousValue;
    } else {
        return 0;
    }
}

}
