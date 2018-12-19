package game;

import functionality.BoardInitializer;
import functionality.BoardReader;
import model.Board;
import model.Cell;
import model.DoubleBoard;
import model.Score;

import java.util.List;

public class Game {
    private DoubleBoard board;
    private Score score;

    public Game(String boardName) {
        this.board = new BoardInitializer().initializeBoard(new BoardReader(boardName));
    }


    private List<Cell> validate() {
        //TODO
        //Compare boards and return difference
        return null;
    }

    public Board getUserBoard() {
        return board.getUserBoard();
    }
}
