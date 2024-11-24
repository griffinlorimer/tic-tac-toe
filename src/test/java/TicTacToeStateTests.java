import simplisafe.takehome.TicTacToe;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicTacToeStateTests {
    @Test
    public void boardWithMovesLeft1() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/board-with-moves-left-1.txt");

        assertTrue(ticTacToe.anyMovesLeft());
        assertFalse(ticTacToe.isGameOver());
    }

    @Test
    public void boardWithMovesLeft2() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/board-with-moves-left-2.txt");

        assertTrue(ticTacToe.anyMovesLeft());
        assertFalse(ticTacToe.isGameOver());
    }

    @Test
    public void boardWithNoMovesLeft1() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-vertical.txt");

        assertTrue(ticTacToe.isGameOver());
        assertFalse(ticTacToe.anyMovesLeft());
    }

    @Test
    public void boardWithNoMovesLeft2() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-second-diagonal.txt");

        assertTrue(ticTacToe.isGameOver());
        assertFalse(ticTacToe.anyMovesLeft());
    }
}
