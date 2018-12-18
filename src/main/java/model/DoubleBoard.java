package model;

public class DoubleBoard {
    private final Board userBoard;
    private final Board finalBoard;

    public DoubleBoard(Board userBoard, Board finalBoard) {
        this.userBoard = userBoard;
        this.finalBoard = finalBoard;
    }

    public Board getUserBoard() {
        return userBoard;
    }

    public Board getFinalBoard() {
        return finalBoard;
    }
}
