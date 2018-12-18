package command;

public interface Command {
    void execute();

    void redo();

    void undo();
}
