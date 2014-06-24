package is.agh.dist.mon.api.service;

import is.agh.dist.mon.api.dto.HostDetailsDto;
import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.dto.ServiceDataDto;
import is.agh.dist.mon.api.dto.ServiceDto;
import java.util.List;

public interface HostService {
    public List<HostDto> findAll();
    public HostDetailsDto findById(int id);
    public void add(HostDto host);

    public ServiceDataDto findServiceDataById(String serviceUrl, int hostId);
}
