package is.agh.dist.mon.gui.service.response;

import java.util.List;

public class FindAllResponse<T> {
    private List<T> entries;

    public List<T> getEntries() {
        return entries;
    }

    public void setHost(List<T> entries) {
        this.entries = entries;
    }
}
