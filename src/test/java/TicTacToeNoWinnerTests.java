import org.junit.Test;
import simplisafe.takehome.BoardValue;
import simplisafe.takehome.TicTacToe;
import simplisafe.takehome.WinningMethod;

import java.util.Optional;

import static org.junit.Assert.*;

public class TicTacToeNoWinnerTests {
    @Test
    public void noWinnerFullBoardOne() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/no-winner-full-1.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertFalse(boardValue.isPresent());
        assertFalse(ticTacToe.getWinningMethod().isPresent());
    }

    @Test
    public void noWinnerFullBoardTwo() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/no-winner-full-2.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertFalse(boardValue.isPresent());
        assertFalse(ticTacToe.getWinningMethod().isPresent());
    }

    @Test
    public void noWinnerNotFullBoardOne() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/no-winner-not-full-1.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertFalse(boardValue.isPresent());
        assertFalse(ticTacToe.getWinningMethod().isPresent());
    }

    @Test
    public void noWinnerNotFullBoardTwo() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/no-winner-not-full-2.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertFalse(boardValue.isPresent());
        assertFalse(ticTacToe.getWinningMethod().isPresent());
    }


}
