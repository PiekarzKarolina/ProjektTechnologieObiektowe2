package game;

import functionality.BoardInitializer;
import functionality.BoardReader;
import model.Board;
import model.DoubleBoard;
import model.Score;

public class Game {
    private final DoubleBoard board;
    private Score score;
    private boolean solved;
    private String boardName;

    public Game(String boardName) {
        this.boardName = boardName;
        this.board = new BoardInitializer().initializeBoard(new BoardReader(boardName));
        this.solved = false;
    }

    public Board getUserBoard() {
        return board.getUserBoard();
    }

    public Board getExpectedBoard() {
        return board.getExpectedBoard();
    }

    public String getBoardName() {
        return boardName;
    }

    public void markAsSolved() {
        this.solved = true;
    }

    public boolean isSolved() {
        return solved;
    }
}
