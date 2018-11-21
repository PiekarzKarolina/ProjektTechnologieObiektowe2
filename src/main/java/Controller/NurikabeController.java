package Controller;

import Command.CommandRegistry;
import Game.Nurikabe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NurikabeController {
    private Stage primaryStage;
    private CommandRegistry commandRegistry;

    public NurikabeController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initLayout(){
     try{
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Nurikabe.class
                .getResource("View/GeneralView.fxml"));
        TabPane rootLayout = (TabPane) loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

    } catch (IOException e) {
        // don't do this in common apps
        e.printStackTrace();
    }

}
    
}

