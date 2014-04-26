package is.agh.dist.mon.api.dto;

import java.util.List;

public class MonitorDto {

    private int id;
    private String name;
    private String address;
    private List<HostDto> hosts;
    private int sync;
    private String downtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<HostDto> getHosts() {
        return hosts;
    }

    public void setHosts(List<HostDto> hosts) {
        this.hosts = hosts;
    }

    public int getSync() {
        return sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime;
    }
    
    
}
