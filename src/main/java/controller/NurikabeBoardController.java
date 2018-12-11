package controller;

import command.CommandRegistry;
import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Board;
import model.Color;

import java.util.*;

public class NurikabeBoardController {
    private NurikabeController controller;
    private CommandRegistry commandRegistry;

    private Game game;

    @FXML
    private CheckBox colorWhite;

    @FXML
    private CheckBox colorBlack;

    @FXML
    private CheckBox colorBlue;

    @FXML
    private CheckBox colorGreen;

    @FXML
    private CheckBox colorPink;

    private Color actualColor = Color.NONE;

    private HashMap<CheckBox, Color> checkBoxes = new HashMap<>();

    private static final int NUM_BUTTON_LINES = 10;
    private static final int BUTTONS_PER_LINE = 10;
    private double BUTTON_PADDING = 0;

    @FXML
    GridPane buttonGrid;

    public void setGame(Game game) {
        this.game = game;
    }

    public void initialize() {
        buttonGrid.setPadding(new Insets(BUTTON_PADDING));
        buttonGrid.setHgap(BUTTON_PADDING);
        buttonGrid.setVgap(BUTTON_PADDING);

        checkBoxes.put(colorBlack, Color.BLACK);
        checkBoxes.put(colorBlue, Color.BLUE);
        checkBoxes.put(colorGreen, Color.GREEN);
        checkBoxes.put(colorPink, Color.PINK);
        checkBoxes.put(colorWhite, Color.WHITE);

        Board userBoard = game.getUserBoard();

        for (int r = 0; r < NUM_BUTTON_LINES; r++)
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {

                BoardButton button = new BoardButton(userBoard.getCells()[r][c].getIslandNumber(), r, c);

                button.setOnAction(event -> {
                    BoardButton clickedButton = (BoardButton) event.getSource();
                    int row = clickedButton.getPositionRow();
                    int column = clickedButton.getPositionColumn();

                    game.getUserBoard().changeCellColor(row, column, actualColor);
                    if (actualColor != Color.NONE)
                        button.setStyle("-fx-background-color:" + actualColor);
                });

                buttonGrid.add(button, c, r);
            }


    }

    @FXML
    public void handleColor(ActionEvent event) {
        for (CheckBox checkBox : checkBoxes.keySet()) {
            Color color = checkBoxes.get(checkBox);

            if (checkBox.isSelected() && actualColor != color) {
                actualColor = color;

                for (CheckBox checkBoxToDisable : checkBoxes.keySet()) {
                    if (checkBox != checkBoxToDisable) checkBoxToDisable.setSelected(false);
                }

                return;
            }
        }

        actualColor = Color.NONE;
    }


}
