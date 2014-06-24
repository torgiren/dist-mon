package is.agh.dist.mon.api.dto;

import java.util.Date;

public class ProblemDto {

    private int id;
    private Integer serviceId;
    private Integer hostId;
    private String status;
    private String value;
    private Date start;
    private Date stop;
    private Integer ack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getService() {
        return serviceId;
    }

    public void setService(Integer service) {
        this.serviceId = service;
    }

    public Integer getHost() {
        return hostId;
    }

    public void setHost(Integer host) {
        this.hostId = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public Integer getAck() {
        return ack;
    }

    public void setAck(Integer ack) {
        this.ack = ack;
    }
}
