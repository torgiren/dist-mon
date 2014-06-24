package is.agh.dist.mon.api.dto;

public class HostDto {
    private int id;
    private String name;
    private String address;
    private int active;
    private int downtime;
    private int monitor;
    
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

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDowntime() {
        return downtime;
    }

    public void setDowntime(int downtime) {
        this.downtime = downtime;
    }
}
