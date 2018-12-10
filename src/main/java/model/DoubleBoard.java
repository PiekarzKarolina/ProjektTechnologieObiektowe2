package model;

public class DoubleBoard {
    private Board userBoard;
    private Board finalBoard;

    public Board getUserBoard() {
        return userBoard;
    }

    public void setUserBoard(Board userBoard) {
        this.userBoard = userBoard;
    }

    public Board getFinalBoard() {
        return finalBoard;
    }

    public void setFinalBoard(Board finalBoard) {
        this.finalBoard = finalBoard;
    }

    public DoubleBoard(Board userBoard, Board finalBoard) {

        this.userBoard = userBoard;
        this.finalBoard = finalBoard;
    }
}
