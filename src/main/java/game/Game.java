package game;

import model.Board;
import model.CellSet;
import model.Score;

import java.util.List;

public class Game {
    private Board userBoard;
    private Board finalBoard;
    private Score score;

    private List<CellSet> validate() {
        //TODO
        //Compare boards and return difference
        return null;
    }

    public Board getUserBoard() {
        return userBoard;
    }
}
