package controller;

import javafx.scene.control.Button;

import java.util.Observable;
import java.util.Observer;

public class BoardButton extends Button implements Observer {
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

    public int getPositionColumn() {
        return positionColumn;
    }

    @Override
    public void update(Observable o, Object arg) {  //o is Cell, arg is Color
        if (arg.toString() != null)
            this.setStyle("-fx-background-color:" + arg);
    }
}
