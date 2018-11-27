package game;

import controller.NurikabeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Nurikabe extends Application {
    private Stage primaryStage;
    private NurikabeController controller;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Nurikabe.class.getResource("/GeneralView.fxml"));
            Parent root = loader.load();

//            TabPane rootLayout = (TabPane) loader.load();
//            Scene scene = new Scene(rootLayout);
//
//            primaryStage.setScene(scene);
//            primaryStage.show();

            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();


            NurikabeController controller = loader.getController();
            controller.initialize();

        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }

//
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("Nurikabe");
//
//        this.controller = new NurikabeController(primaryStage);
//        this.controller.initLayout();

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

    }

    public static void main(String[] args) {
        System.out.println("game.Nurikabe");
        launch(args);
    }

}
