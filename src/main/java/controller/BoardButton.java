package controller;

import javafx.scene.control.Button;

public class BoardButton extends Button {
    private int positionRow;
    private int positionColumn;

    public BoardButton(String text, int row, int column) {
        super(text);
        this.positionRow = row;
        this.positionColumn = column;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public void setPositionColumn(int positionColumn) {
        this.positionColumn = positionColumn;
    }
}
