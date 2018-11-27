package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.Score;
import command.CommandRegistry;
import javafx.scene.control.Button;
import model.Board;

public class NurikabeBoardController {
    private NurikabeController controller;
    private CommandRegistry commandRegistry;
    private Board board;
    private Score score;

    private Button checkButton;
    private Button newGameButton;
    private Button rankButton;

    private static final int NUM_BUTTON_LINES = 10;
    private static final int BUTTONS_PER_LINE = 10;
    private double BUTTON_PADDING = 0;

    @FXML
    GridPane buttonGrid;

    public void initialize() {
        buttonGrid.setPadding(new Insets(BUTTON_PADDING));
        buttonGrid.setHgap(BUTTON_PADDING);
        buttonGrid.setVgap(BUTTON_PADDING);

        for (int r = 0; r < NUM_BUTTON_LINES; r++) {
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {
                int number = NUM_BUTTON_LINES * r + c;
                Button button = new Button(String.valueOf(number));
                button.setText("   ");
                buttonGrid.add(button, c, r);
            }
        }


    }

    public void handleCheckAction() {
        //TODO
    }

    public void handleColor1() {
        //TODO
    }

    public void handleColor2() {
        //TODO
    }

    public void handleNewGameAction() {
        //TODO
    }

    public void handleRankAction() {
        //TODO
    }
}
