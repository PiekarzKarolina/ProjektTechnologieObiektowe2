package controller;

import command.CommandRegistry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NurikabeComandController {
    private CommandRegistry commandRegistry;

    @FXML
    private Button undoButton;

    @FXML
    private Button redoButton;


    public void handleUndoAction() {
        commandRegistry.undo();
    }

    public void handleRedoAction() {
        commandRegistry.redo();
    }

    public void setCommandRegistry(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }
}
