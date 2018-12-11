package command;

public interface Command {

    public void execute();

    public void redo();

    public void undo();
}
