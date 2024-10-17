package walking.game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import walking.game.util.Direction;
import static org.junit.jupiter.api.Assertions.*;

public class WalkingBoardTest {

    @Test
    void testSimpleInit() {
        int size = 5;
        WalkingBoard board = new WalkingBoard(size);
        int[][] tiles = board.getTiles();
        assertEquals(size, tiles.length);
        assertEquals(size, tiles[0].length);
        for (int[] row : tiles) {
            for (int tile : row) {
                assertEquals(WalkingBoard.BASE_TILE_SCORE, tile);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3",
        "2, 2, 3",
        "4, 4, 3"
    })
    void testCustomInit(int x, int y, int expected) {
        int[][] tiles = new int[5][5];
        tiles[x][y] = 2;
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(expected, board.getTile(x, y));
    }

    @Test
    void testMoves() {
        WalkingBoard board = new WalkingBoard(5);
        board.moveAndSet(Direction.RIGHT, 1);
        board.moveAndSet(Direction.DOWN, 2);
        board.moveAndSet(Direction.LEFT, 3);
        board.moveAndSet(Direction.UP, 4);
        int[] position = board.getPosition();
        assertEquals(0, position[0]);
        assertEquals(0, position[1]);
        assertEquals(4, board.getTile(0, 0));
    }

    @Test
    void testInvalidMoves() {
        WalkingBoard board = new WalkingBoard(5);
        board.moveAndSet(Direction.LEFT, 1);
        int[] position = board.getPosition();
        assertEquals(0, position[0]);
        assertEquals(0, position[1]);
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(0, 0));
    }
}
