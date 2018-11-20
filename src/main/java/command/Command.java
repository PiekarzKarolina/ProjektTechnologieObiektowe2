package command;

public interface Command {

    public void executeCommand();

    public void redo();

    public void undo();
    //TODO
}
