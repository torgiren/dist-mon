package is.agh.dist.mon.api.dto;

import java.util.List;

public class HostDto {

    private int id;
    private String name;
    private String address;
    private Integer monitor;
    private List<Integer> notify;
    private List<Integer> services;
    private boolean active;
    private int downtime;
    
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

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public List<Integer> getNotify() {
        return notify;
    }

    public void setNotify(List<Integer> notify) {
        this.notify = notify;
    }

    public List<Integer> getServices() {
        return services;
    }

    public void setServices(List<Integer> services) {
        this.services = services;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDowntime() {
        return downtime;
    }

    public void setDowntime(int downtime) {
        this.downtime = downtime;
    }
}
