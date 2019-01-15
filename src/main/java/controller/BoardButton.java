package controller;

import javafx.scene.control.Button;
import model.Color;

import java.util.Observable;
import java.util.Observer;

public class BoardButton extends Button implements Observer {
    private int positionRow;
    private int positionColumn;

    BoardButton(String text, int row, int column) {
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
        if (arg.toString() != null) {
            if(arg.equals(Color.PINK) || arg.equals(Color.AQUA) || arg.equals(Color.GREENYELLOW)){
                this.setStyle("-fx-background-color:" + arg + ";" + "-fx-background-image:" + "url(palma.png)");
            }
            else{
                this.setStyle("-fx-background-color:" + arg);
            }
        }

    }
}
