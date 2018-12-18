package command;

import game.Game;
import javafx.scene.control.Button;
import model.Color;

public class ChangeColorCommand implements Command {
    private Game game;
    private int row, column;
    private Color actualColor;
    private Color previousColor;


    public ChangeColorCommand(int row, int column, Color actualColor, Color previousColor, Game game) {
        this.row = row;
        this.column = column;
        this.actualColor = actualColor;
        this.previousColor = previousColor;
        this.game = game;

    }

    @Override
    public void execute() {
        game.getUserBoard().setCellColor(row, column, actualColor);
    }

    @Override
    public void redo() {
        game.getUserBoard().setCellColor(row, column, actualColor);
    }

    @Override
    public void undo() {
        game.getUserBoard().setCellColor(row, column, previousColor);
    }

}
