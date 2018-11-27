package controller;

import command.CommandRegistry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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

        for (int r = 0; r < NUM_BUTTON_LINES; r++) {
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {
                int number = NUM_BUTTON_LINES * r + c;
                Button button = new Button(String.valueOf(number));
                button.setText("   ");
                buttonGrid.add(button, c, r);
            }
        }


    }

    @FXML
    public void handleColorWhite(ActionEvent event) {
        if (colorWhite.isSelected()) {

            switch (actualColor) {
                case Black:
                    colorBlack.setSelected(false);
                case Blue:
                    colorBlue.setSelected(false);
                case Green:
                    colorGreen.setSelected(false);
                case Pink:
                    colorPink.setSelected(false);
                case Null:
                    actualColor = ActualColor.White;
            }
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
                case Blue:
                    colorBlue.setSelected(false);
                case Green:
                    colorGreen.setSelected(false);
                case Pink:
                    colorPink.setSelected(false);
                case Null:
                    actualColor = ActualColor.Black;
            }
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorBlue(ActionEvent event) {
        System.out.println("blue");
        if (colorBlue.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                case Black:
                    colorBlack.setSelected(false);
                case Green:
                    colorGreen.setSelected(false);
                case Pink:
                    colorPink.setSelected(false);
                case Null:
                    actualColor = ActualColor.Blue;
            }
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorGreen(ActionEvent event) {
        System.out.println("green");
        if (colorGreen.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                case Black:
                    colorBlack.setSelected(false);
                case Blue:
                    colorBlue.setSelected(false);
                case Pink:
                    colorPink.setSelected(false);
                case Null:
                    actualColor = ActualColor.Green;
            }
        }
        else{
            actualColor = ActualColor.Null;
        }
    }

    @FXML
    public void handleColorPink(ActionEvent event) {
        System.out.println("pink");
        if (colorPink.isSelected()) {

            switch (actualColor) {
                case White:
                    colorWhite.setSelected(false);
                case Black:
                    colorBlack.setSelected(false);
                case Green:
                    colorGreen.setSelected(false);
                case Blue:
                    colorBlue.setSelected(false);
                case Null:
                    actualColor = ActualColor.Pink;
            }
        } else {
            actualColor = ActualColor.Null;
        }

    }
}
