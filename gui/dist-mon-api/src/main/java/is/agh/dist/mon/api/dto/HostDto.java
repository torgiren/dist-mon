package is.agh.dist.mon.api.dto;

import java.util.List;

public class HostDto {

    private int id;
    private String name;
    private String address;
    private List<UserDto> notify;
    private List<ServiceDto> services;
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

    public List<UserDto> getNotify() {
        return notify;
    }

    public void setNotify(List<UserDto> notify) {
        this.notify = notify;
    }

    public List<ServiceDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDto> services) {
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
