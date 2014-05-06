package is.agh.dist.mon.api.service;

import is.agh.dist.mon.api.dto.ServiceDto;

import java.util.List;


public interface MeasurementService {
    public List<ServiceDto> findAll();
    public ServiceDto findById(int id);
    public void add(ServiceDto host);
}
