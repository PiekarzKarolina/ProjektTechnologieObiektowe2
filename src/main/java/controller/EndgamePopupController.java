package controller;

/**
 * Sample Skeleton for "Untitled" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import functionality.ScoreHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EndgamePopupController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TextField nicknameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton;

    @FXML
    private Text timeText;

    private long result;
    private String boardName;
    ScoreHandler rankingHandler;

    DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );

    public EndgamePopupController(long result, String boardName) {
        this.result = result;
        this.boardName = boardName;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        String timeString = timeFormat.format( result );
        timeText.setText("Yor time is " + timeString);

        rankingHandler = new ScoreHandler();

        saveButton.setOnAction(event -> {
            String nickName = nicknameTextField.getText();
            rankingHandler.saveScore(boardName, nickName + " " + timeString);
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        });

        // Initialize your logic here: all @FXML variables will have been injected

    }

}