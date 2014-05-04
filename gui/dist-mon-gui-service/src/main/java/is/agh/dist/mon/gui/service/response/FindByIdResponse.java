package is.agh.dist.mon.gui.service.response;

public class FindByIdResponse<T> {
    private T entry;

    public T getEntry() {
        return entry;
    }

    public void setEntry(T entry) {
        this.entry = entry;
    }
}
