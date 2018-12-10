package game;

import functionality.BoardInitializer;
import model.Board;
import model.DoubleBoard;
import model.CellSet;
import model.Score;

import java.util.List;

public class Game {
    private DoubleBoard board;
    private Score score;

    Game (String boardName){
        BoardInitializer boardInitializer = new BoardInitializer();
        this.board = boardInitializer.initializeBoard(boardName);
    }


    private List<CellSet> validate() {
        //TODO
        //Compare boards and return difference
        return null;
    }

    public Board getUserBoard() {
        return board.getUserBoard();
    }
}
