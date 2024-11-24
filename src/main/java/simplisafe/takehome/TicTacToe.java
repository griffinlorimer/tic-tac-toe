package simplisafe.takehome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class TicTacToe {
    public BoardValue[][] ticTacToeBoard;
    private int BOARD_DIMENSION = 4;
    private boolean anyMovesLeft;
    private Optional<WinningMethod> winningMethod;

    public TicTacToe(String pathToBoardFile) {
        this.ticTacToeBoard = new BoardValue[BOARD_DIMENSION][BOARD_DIMENSION];
        this.anyMovesLeft = false;
        this.winningMethod = Optional.empty();

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToBoardFile));
            for (int i = 0; i < BOARD_DIMENSION; i++) {
                String line = br.readLine();
                char[] charArray = (line != null) ? line.toCharArray() : new char[0]; // set to an empty array if the line does not exist
                for (int j = 0; j < BOARD_DIMENSION; j++) {
                    char c = (j < charArray.length) ? charArray[j] : ' '; // get the current character in the line.  If it doesn't exist, set it to ' '
                    if (!anyMovesLeft && c == ' ') anyMovesLeft = true;
                    ticTacToeBoard[i][j] = parseBoardValue(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the tic tac toe board file", e);
        }
    }

    public boolean anyMovesLeft() {
        return anyMovesLeft;
    }

    public boolean isGameOver() {
        return !anyMovesLeft || winningMethod.isPresent();
    }

    public Optional<WinningMethod> getWinningMethod() {
        return winningMethod;
    }

    public Optional<BoardValue> checkWinner() {
        Optional<BoardValue> horizontalWin = checkHorizontalWin();
        if (horizontalWin.isPresent()) {
            this.winningMethod = Optional.of(WinningMethod.HORIZONTAL);
            return horizontalWin;
        }
        Optional<BoardValue> verticalWin = checkVerticalWin();
        if (verticalWin.isPresent()) {
            this.winningMethod = Optional.of(WinningMethod.VERTICAL);
            return verticalWin;
        }
        Optional<BoardValue> diagonalWin = checkDiagonalWin();
        if (diagonalWin.isPresent()) {
            this.winningMethod = Optional.of(WinningMethod.DIAGONAL);
            return diagonalWin;
        }
        Optional<BoardValue> fourCorners = checkFourCornersWin();
        if (fourCorners.isPresent()) {
            this.winningMethod = Optional.of(WinningMethod.FOUR_CORNERS);
            return fourCorners;
        }
        Optional<BoardValue> boxWin = checkBoxWin();
        if (boxWin.isPresent()) {
            this.winningMethod = Optional.of(WinningMethod.BOX);
            return boxWin;
        }

        return Optional.empty();
    }


    private BoardValue parseBoardValue(Character character) {
        switch (character) {
            case 'X':
                return BoardValue.X;
            case 'O':
                return BoardValue.O;
            case ' ':
                return BoardValue.EMPTY;
            default:
                throw new IllegalArgumentException("Invalid character " + character);
        }
    }

    private Optional<BoardValue> checkHorizontalWin() {
        for (int i = 0; i < BOARD_DIMENSION; i++) {
            BoardValue last = ticTacToeBoard[i][0];
            boolean horizontalWin = true;
            for (int j = 1; j < BOARD_DIMENSION; j++) {
                if (last == BoardValue.EMPTY || ticTacToeBoard[i][j] != last) {
                    horizontalWin = false;
                    break;
                }
            }
            if (horizontalWin) return Optional.of(last);
        }
        return Optional.empty();
    }

    private Optional<BoardValue> checkVerticalWin() {
        for (int i = 0; i < BOARD_DIMENSION; i++) {
            BoardValue last = ticTacToeBoard[0][i];
            boolean verticalWin = true;
            for (int j = 1; j < BOARD_DIMENSION; j++) {
                if (last == BoardValue.EMPTY || ticTacToeBoard[j][i] != last) {
                    verticalWin = false;
                    break;
                }
            }
            if (verticalWin) return Optional.of(last);
        }
        return Optional.empty();
    }

    private Optional<BoardValue> checkDiagonalWin() {
        BoardValue firstDiagonal = ticTacToeBoard[0][0];
        boolean firstDiagonalWin = true;
        for (int i = 1; i < BOARD_DIMENSION; i++) {
            if (firstDiagonal == BoardValue.EMPTY || ticTacToeBoard[i][i] != firstDiagonal) {
                firstDiagonalWin = false;
                break;
            }
        }
        if (firstDiagonalWin) return Optional.of(firstDiagonal);

        BoardValue secondDiagonal = ticTacToeBoard[0][BOARD_DIMENSION - 1];
        boolean secondDiagonalWin = true;
        for (int i = 1; i < BOARD_DIMENSION; i++) {
            if (secondDiagonal == BoardValue.EMPTY || ticTacToeBoard[i][BOARD_DIMENSION - i - 1] != secondDiagonal) {
                secondDiagonalWin = false;
                break;
            }
        }
        if (secondDiagonalWin) return Optional.of(secondDiagonal);

        return Optional.empty();
    }

    private Optional<BoardValue> checkFourCornersWin() {
        BoardValue topLeft = ticTacToeBoard[0][0];
        BoardValue topRight = ticTacToeBoard[0][BOARD_DIMENSION - 1];
        BoardValue bottomLeft = ticTacToeBoard[BOARD_DIMENSION - 1][0];
        BoardValue bottomRight = ticTacToeBoard[BOARD_DIMENSION - 1][BOARD_DIMENSION - 1];
        if (topLeft != BoardValue.EMPTY && topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
            return Optional.of(topLeft);
        }

        return Optional.empty();
    }

    private Optional<BoardValue> checkBoxWin() {
        // iterate over all possible 2x2 boards
        for (int i = 0; i < BOARD_DIMENSION - 1; i++) {
            for (int j = 0; j < BOARD_DIMENSION - 1; j++) {
                BoardValue topLeft = ticTacToeBoard[i][j];
                BoardValue topRight = ticTacToeBoard[i][j + 1];
                BoardValue bottomLeft = ticTacToeBoard[i + 1][j];
                BoardValue bottomRight = ticTacToeBoard[i + 1][j + 1];

                if (topLeft != BoardValue.EMPTY && topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                    return Optional.of(topLeft);
                }
            }
        }

        return Optional.empty();
    }


}
