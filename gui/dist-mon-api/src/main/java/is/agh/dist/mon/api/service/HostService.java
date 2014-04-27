package is.agh.dist.mon.api.service;

import is.agh.dist.mon.api.dto.HostDto;
import java.util.List;

public interface HostService {
    public List<HostDto> findAll();
    public HostDto findById(int id);
}
