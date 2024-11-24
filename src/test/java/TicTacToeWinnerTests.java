import simplisafe.takehome.BoardValue;
import simplisafe.takehome.TicTacToe;
import org.junit.Test;
import simplisafe.takehome.WinningMethod;

import java.util.Optional;

import static org.junit.Assert.*;

public class TicTacToeWinnerTests {
    @Test
    public void xVerticalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-vertical.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.X, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.VERTICAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void oVerticalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-vertical.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.O, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.VERTICAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void xHorizontalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-horizontal.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.X, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.HORIZONTAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void oHorizontalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-horizontal.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.O, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.HORIZONTAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void xFirstDiagonalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-first-diagonal.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.X, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.DIAGONAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void oSecondDiagonalWinner() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-second-diagonal.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.O, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.DIAGONAL, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void oFourCornersWin() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-four-corners.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.O, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.FOUR_CORNERS, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void xFourCornersWin() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-four-corners.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.X, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.FOUR_CORNERS, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void oBoxWin() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/o-winner-box.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.O, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.BOX, ticTacToe.getWinningMethod().get());
    }

    @Test
    public void xBoxWin() {
        TicTacToe ticTacToe = new TicTacToe("src/test/resources/x-winner-box.txt");
        Optional<BoardValue> boardValue = ticTacToe.checkWinner();

        assertTrue(boardValue.isPresent());
        assertEquals(BoardValue.X, boardValue.get());
        assertTrue(ticTacToe.getWinningMethod().isPresent());
        assertEquals(WinningMethod.BOX, ticTacToe.getWinningMethod().get());
    }
}
