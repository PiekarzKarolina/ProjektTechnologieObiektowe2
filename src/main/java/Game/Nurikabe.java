package Game;

import Controller.NurikabeController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Nurikabe {
    private Stage primaryStage;
    private NurikabeController controller;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nurikabe");

        this.controller = new NurikabeController(primaryStage);
        this.controller.initLayout();

    }
    public static void main(String [] args){
        System.out.println("Game.Nurikabe");
        launch(args);
    }

}
