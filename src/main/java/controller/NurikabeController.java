package controller;

import command.CommandRegistry;
import game.Nurikabe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NurikabeController {
    private Stage primaryStage;
    private CommandRegistry commandRegistry;

    @FXML
    private GridPane game;

    public NurikabeController(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.add(new Button("XDs"), i, j);
            }
        }
    }

//    public void initLayout() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Nurikabe.class.getResource("/GeneralView.fxml"));
//            TabPane rootLayout = (TabPane) loader.load();
//            Scene scene = new Scene(rootLayout);
//
//
//            primaryStage.setScene(scene);
//            primaryStage.show();
//
//        } catch (IOException e) {
//            // don't do this in common apps
//            e.printStackTrace();
//        }
//
//    }

}

