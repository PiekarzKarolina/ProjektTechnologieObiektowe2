package command;

import game.Game;
import javafx.scene.control.Button;
import model.Color;

public class ChangeColorCommand implements Command {
    private Game game;
    private int row, column;
    private Color actualColor;
    private Color previousColor;
    private Button button;

    public ChangeColorCommand(int row, int column, Color actualColor, Color previousColor, Game game, Button button){
        this.row = row;
        this.column = column;
        this.actualColor = actualColor;
        this.previousColor = previousColor;
        this.game = game;
        this.button = button;
    }

    @Override
    public void execute() {
        game.getUserBoard().changeCellColor(row, column, actualColor);
        if (actualColor != Color.NONE)
            button.setStyle("-fx-background-color:" + actualColor);
    }

    @Override
    public void redo() {
        game.getUserBoard().changeCellColor(row, column, actualColor);
        button.setStyle("-fx-background-color:" + actualColor);

    }

    @Override
    public void undo() {
        game.getUserBoard().changeCellColor(row, column, previousColor);
        button.setStyle("-fx-background-color:" + previousColor);
    }

}
