package controller;

import command.CommandRegistry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import model.Board;
import model.Score;

public class NurikabeBoardController {
    private NurikabeController controller;
    private CommandRegistry commandRegistry;
    private Board board;
    private Score score;

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

    private enum ActualColor {White, Black, Blue, Green, Pink, Null}

    ActualColor actualColor = ActualColor.Null;


    private static final int NUM_BUTTON_LINES = 10;
    private static final int BUTTONS_PER_LINE = 10;
    private double BUTTON_PADDING = 0;

    @FXML
    GridPane buttonGrid;

    public void initialize() {
        buttonGrid.setPadding(new Insets(BUTTON_PADDING));
        buttonGrid.setHgap(BUTTON_PADDING);
        buttonGrid.setVgap(BUTTON_PADDING);

        for (int r = 0; r < NUM_BUTTON_LINES; r++)
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {
                int number = NUM_BUTTON_LINES * r + c;
                BoardButton button = new BoardButton("   ", r, c);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                       /* BoardButton clickedButton = (BoardButton) event.getSource();
                        int row =  clickedButton.getPositionRow();
                        int column = clickedButton.getPositionColumn();
                        */
                        switch (actualColor) {
                            case White:
                                button.setStyle("-fx-background-color: white");
                                break;
                            case Black:
                                button.setStyle("-fx-background-color: black");
                                break;
                            case Blue:
                                button.setStyle("-fx-background-color: blue");
                                break;
                            case Green:
                                button.setStyle("-fx-background-color: green");
                                break;
                            case Pink:
                                button.setStyle("-fx-background-color: pink");
                                break;
                        }

                    }
                });
                buttonGrid.add(button, c, r);
            }


    }

    @FXML
    public void handleColorWhite(ActionEvent event) {
        if (colorWhite.isSelected()) {

            switch (actualColor) {
                case Black:
                    colorBlack.setSelected(false);
                    break;
                case Blue:
                    colorBlue.setSelected(false);
                    break;
                case Green:
                    colorGreen.setSelected(false);
                    break;
                case Pink:
                    colorPink.setSelected(false);
                    break;
                case Null:
                    actualColor = ActualColor.White;
                    break;
            }
            actualColor = ActualColor.White;
            } else {
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorBlack(ActionEvent event) {
        if (colorBlack.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                    break;
                case Blue:
                    colorBlue.setSelected(false);
                    break;
                case Green:
                    colorGreen.setSelected(false);
                    break;
                case Pink:
                    colorPink.setSelected(false);
                    break;
                case Null:
                    actualColor = ActualColor.Black;
                    break;
            }
            actualColor = ActualColor.Black;
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorBlue(ActionEvent event) {
        if (colorBlue.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                    break;
                case Black:
                    colorBlack.setSelected(false);
                    break;
                case Green:
                    colorGreen.setSelected(false);
                    break;
                case Pink:
                    colorPink.setSelected(false);
                    break;
                case Null:
                    actualColor = ActualColor.Blue;
                    break;
            }
            actualColor = ActualColor.Blue;
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorGreen(ActionEvent event) {
        if (colorGreen.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                    break;
                case Black:
                    colorBlack.setSelected(false);
                    break;
                case Blue:
                    colorBlue.setSelected(false);
                    break;
                case Pink:
                    colorPink.setSelected(false);
                    break;
                case Null:
                    actualColor = ActualColor.Green;
                    break;
            }
            actualColor = ActualColor.Green;
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorPink(ActionEvent event) {
        if (colorPink.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                    break;
                case Black:
                    colorBlack.setSelected(false);
                    break;
                case Green:
                    colorGreen.setSelected(false);
                    break;
                case Blue:
                    colorBlue.setSelected(false);
                    break;
                case Null:
                    actualColor = ActualColor.Pink;
                    break;
            }
            actualColor = ActualColor.Pink;
        } else {
            actualColor = ActualColor.Null;
        }
    }
}
