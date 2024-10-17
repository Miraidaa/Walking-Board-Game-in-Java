package walking.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class WalkingBoardWithPlayersTest {

    @ParameterizedTest
    @CsvSource({
        "3, 3, 3, 3",
        "2, 2, 2, 2"
    })
    void walk1(int playerCount, int step1, int step2, int step3) {
        int[][] board1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        WalkingBoardWithPlayers walkingBoardWithPlayers = new WalkingBoardWithPlayers(board1, playerCount);
        int[] scores = walkingBoardWithPlayers.walk(step1, step2, step3);
        for (int score : scores) {
            assertTrue(score >= 0);
        }
    }

@ParameterizedTest
@CsvSource({
    "4, 3, 3, 3",
    "5, 2, 2, 2"
})
void walk2(int playerCount, int step1, int step2, int step3) {
    int[][] board2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    WalkingBoardWithPlayers walkingBoardWithPlayers = new WalkingBoardWithPlayers(board2, playerCount);
    int[] scores = walkingBoardWithPlayers.walk(step1, step2, step3);
    for (int score : scores) {
        assertTrue(score >= 0);
    }
}
}