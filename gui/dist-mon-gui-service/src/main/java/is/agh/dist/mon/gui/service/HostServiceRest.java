package is.agh.dist.mon.gui.service;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.service.HostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HostServiceRest implements HostService {

    @Value("${catalog.address}")
    private String catalogAddress;
    @Value("${catalog.host}")
    private String hostQuery;
    @Value("${catalog.hostById}")
    private String hostByIdQuery;
            
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<HostDto> findAll() {
        ResponseEntity<FindAllResponse> response = restTemplate.getForEntity(catalogAddress + hostQuery, FindAllResponse.class);
        return response.getBody().getHost();
    }

    @Override
    public HostDto findById(int id) {
        ResponseEntity<FindByIdResponse> response = restTemplate.getForEntity(catalogAddress + hostByIdQuery, FindByIdResponse.class, id);
        return response.getBody().getHost();
    }
    
    private static class FindAllResponse {
        private List<HostDto> host;

        public List<HostDto> getHost() {
            return host;
        }

        public void setHost(List<HostDto> host) {
            this.host = host;
        }
    }

    private static class FindByIdResponse {
        private HostDto host;

        public HostDto getHost() {
            return host;
        }

        public void setHost(HostDto host) {
            this.host = host;
        }
    }
}
