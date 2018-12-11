package command;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CommandRegistry {
    private ObservableList<Command> commandStack = FXCollections.observableArrayList();
    private ObservableList<Command> redoCommandStack = FXCollections.observableArrayList();
    public void executeCommand(Command command) {
        command.execute();
        commandStack.add(command);
        redoCommandStack.clear();
    }


    public void redo() {
        if(!redoCommandStack.isEmpty()){
            Command command = redoCommandStack.remove(redoCommandStack.size()-1);
            command.redo();
            redoCommandStack.add(command);
        }
    }

    public void undo() {

        if(!commandStack.isEmpty()){
            Command command = commandStack.remove(commandStack.size()-1);
            command.undo();
            redoCommandStack.add(command);
        }
    }

    public ObservableList<Command> getCommandStack() {
        return commandStack;
    }
}
