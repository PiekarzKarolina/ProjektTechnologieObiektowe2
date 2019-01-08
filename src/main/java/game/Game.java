package game;

import functionality.BoardInitializer;
import functionality.BoardReader;
import model.Board;
import model.Cell;
import model.DoubleBoard;
import model.Score;

import java.util.List;

public class Game {
    private final DoubleBoard board;
    private Score score;
    private boolean solved;

    public Game(String boardName) {
        this.board = new BoardInitializer().initializeBoard(new BoardReader(boardName));
        this.solved = false;
    }

    public Board getUserBoard() {
        return board.getUserBoard();
    }

    public Board getExpectedBoard() {
        return board.getExpectedBoard();
    }

    public void markAsSolved() {
        this.solved = true;
    }

    public boolean isSolved() {
        return solved;
    }
}
