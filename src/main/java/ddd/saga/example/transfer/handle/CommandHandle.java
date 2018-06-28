package ddd.saga.example.transfer.handle;

public interface CommandHandle<T> {
    public void execute(T command);
}
