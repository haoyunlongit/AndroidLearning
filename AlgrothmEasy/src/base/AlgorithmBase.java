package base;

public abstract class AlgorithmBase {
    protected abstract void doExecute();

    public void execute() {
        doExecute();
    }
}
