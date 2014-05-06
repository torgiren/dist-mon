package is.agh.dist.mon.gui.service;

import is.agh.dist.mon.api.dto.MonitorDto;
import is.agh.dist.mon.api.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MonitorServiceRest implements MonitorService {

    @Value("${catalog.address}")
    private String catalogAddress;
    @Value("${catalog.monitor}")
    private String monitorQuery;
    @Value("${catalog.monitorById}")
    private String monitorByIdQuery;
            
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<MonitorDto> findAll() {
        ResponseEntity<FindAllResponse> response = restTemplate.getForEntity(catalogAddress + monitorQuery, FindAllResponse.class);
        return response.getBody().getMonitor();
    }

    @Override
    public MonitorDto findById(int id) {
        ResponseEntity<FindByIdResponse> response = restTemplate.getForEntity(catalogAddress + monitorByIdQuery, FindByIdResponse.class, id);
        return response.getBody().getMonitor();
    }

    @Override
    public void add(MonitorDto monitor) {
        ResponseEntity<AddResponse> response = restTemplate.postForEntity(catalogAddress + monitorQuery, monitor, AddResponse.class);
    }
    
    private static class FindAllResponse {
        private List<MonitorDto> monitor;

        public List<MonitorDto> getMonitor() {
            return monitor;
        }

        public void setMonitor(List<MonitorDto> monitor) {
            this.monitor = monitor;
        }
    }

    private static class FindByIdResponse {
        private MonitorDto monitor;

        public MonitorDto getMonitor() {
            return monitor;
        }

        public void setMonitor(MonitorDto monitor) {
            this.monitor = monitor;
        }
    }

    private static class AddResponse {
        private MonitorDto monitor;

        public MonitorDto getMonitor() {
            return monitor;
        }

        public void setMonitor(MonitorDto monitor) {
            this.monitor = monitor;
        }
    }
}
