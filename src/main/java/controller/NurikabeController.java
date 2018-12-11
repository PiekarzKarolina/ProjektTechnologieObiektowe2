package controller;

import command.CommandRegistry;
import game.Game;
import game.Nurikabe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NurikabeController {
    private Stage primaryStage;
    private CommandRegistry commandRegistry;

    public NurikabeController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initLayout(Game game) {
        try {
            String xmlFile = "/GeneralView.fxml";

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Nurikabe.class.getResource(xmlFile));
            TabPane rootLayout = (TabPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            NurikabeBoardController controller = loader.getController();
            controller.setGame(game);
            //controller.populateBoard();

        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }

    }

}

