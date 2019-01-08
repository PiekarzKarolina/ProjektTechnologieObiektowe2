package model;

public class DoubleBoard {
    private final Board userBoard;
    private final Board expectedBoard;

    public DoubleBoard(Board userBoard, Board expectedBoard) {
        this.userBoard = userBoard;
        this.expectedBoard = expectedBoard;
    }

    public Board getUserBoard() {
        return userBoard;
    }

    public Board getExpectedBoard() {
        return expectedBoard;
    }
}
