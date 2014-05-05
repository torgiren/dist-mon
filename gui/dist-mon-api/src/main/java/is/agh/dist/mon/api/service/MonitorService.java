package is.agh.dist.mon.api.service;

import is.agh.dist.mon.api.dto.MonitorDto;

import java.util.List;

public interface MonitorService {
    public List<MonitorDto> findAll();
    public MonitorDto findById(int id);
}
