package controller;

import command.ChangeColorCommand;
import command.CommandRegistry;
import functionality.BoardValidator;
import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Board;
import model.Cell;
import model.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NurikabeBoardController {

    private Game game;
    private CommandRegistry commandRegistry;

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

    @FXML
    private Button checkButton;

    private Color actualColor = Color.NONE;

    private Color previousColor;

    private HashMap<CheckBox, Color> checkBoxes = new HashMap<>();

    private ArrayList<BoardButton> buttons = new ArrayList<>();

    private static final int NUM_BUTTON_LINES = 10;
    private static final int BUTTONS_PER_LINE = 10;
    private double BUTTON_PADDING = 0;

    @FXML
    GridPane buttonGrid;

    public void setGame(Game game) {
        System.out.println("Game set");
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

        for (int r = 0; r < NUM_BUTTON_LINES; r++) {
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {

                BoardButton button = new BoardButton("   ", r, c);

                button.setOnAction(event -> {
                    BoardButton clickedButton = (BoardButton) event.getSource();
                    int row = clickedButton.getPositionRow();
                    int column = clickedButton.getPositionColumn();
                    previousColor = game.getUserBoard().getCellColor(row, column);
                    if (actualColor != Color.NONE && actualColor != previousColor) { // ZROBIĆ TO ŁADNIEJ XD
                        ChangeColorCommand changeColorCommand = new ChangeColorCommand(row, column, actualColor, previousColor, game);
                        commandRegistry.executeCommand(changeColorCommand);
                    }
                });
                buttonGrid.add(button, c, r);
                buttons.add(button);
            }
        }

        checkButton.setOnMousePressed((event) -> highlightIllegal());
        checkButton.setOnMouseReleased((event) -> unhighlightIllegal());

    }

    public void populateBoard() {
        Board userBoard = game.getUserBoard();

        buttons.forEach(button -> {
            Cell cell = userBoard.getCell(button.getPositionRow(), button.getPositionColumn());
            button.setText(cell.getIslandNumber());
            button.setStyle("-fx-background-color:" + cell.getColor());
            cell.addObserver(button);
        });
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

    public void handleUndo(ActionEvent event) {
        commandRegistry.undo();
    }

    public void handleRedo(ActionEvent event) {
        commandRegistry.redo();
    }

    public void setCommandRegistry(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }


    private void highlightIllegal() {
        BoardValidator validator = new BoardValidator(game.getExpectedBoard(), game.getUserBoard());
        if (validator.isSolved()) {
            game.markAsSolved();
            return;
        }

        Cell[][] diff = validator.getDiff();
//        System.out.println(buttons);
        for (int y = 0; y < NUM_BUTTON_LINES; y++) {
            for (int x = 0; x < BUTTONS_PER_LINE; x++) {
                if (diff[x][y] != null) {
                    Button button = buttons.get(x + y * NUM_BUTTON_LINES);
                    button.setStyle("-fx-background-color: red");
                }
//                System.out.print("(" + x + ", " + y + ") " + diff[x][y] + " ");
            }
//            System.out.println();
        }
    }

    private void unhighlightIllegal() {
        if (game.isSolved()) return;

        for (int y = 0; y < NUM_BUTTON_LINES; y++) {
            for (int x = 0; x < BUTTONS_PER_LINE; x++) {
                Button button = buttons.get(x + y * NUM_BUTTON_LINES);
                button.setStyle("-fx-background-color:" + game.getUserBoard().getCell(x, y).getColor());
            }
        }
    }
}

