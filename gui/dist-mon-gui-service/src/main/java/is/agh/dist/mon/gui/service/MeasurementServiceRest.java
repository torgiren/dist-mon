package is.agh.dist.mon.gui.service;

import is.agh.dist.mon.api.dto.ServiceDto;
import is.agh.dist.mon.api.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MeasurementServiceRest implements MeasurementService {

    @Value("${catalog.address}")
    private String catalogAddress;
    @Value("${catalog.service}")
    private String serviceQuery;
    @Value("${catalog.serviceById}")
    private String serviceByIdQuery;

    public String getServiceQuery() {
        return serviceQuery;
    }
    
    @Autowired 
   private RestTemplate restTemplate;
    
    @Override
    public List<ServiceDto> findAll() {
        ResponseEntity<FindAllResponse> response = restTemplate.getForEntity(catalogAddress + serviceQuery, FindAllResponse.class);
        return response.getBody().getService();
    }

    @Override
    public ServiceDto findById(int id) {
        ResponseEntity<FindByIdResponse> response = restTemplate.getForEntity(catalogAddress + serviceByIdQuery, FindByIdResponse.class, id);
        return response.getBody().getService();
    }

    @Override
    public void add(ServiceDto service) {
        restTemplate.postForLocation(catalogAddress + serviceQuery, service);
    }
    
    private static class FindAllResponse {
        private List<ServiceDto> service;

        public List<ServiceDto> getService() {
            return service;
        }

        public void setService(List<ServiceDto> service) {
            this.service = service;
        }
    }

    private static class FindByIdResponse {
        private ServiceDto service;

        public ServiceDto getService() {
            return service;
        }

        public void setService(ServiceDto service) {
            this.service = service;
        }
    }

    private static class AddServiceResponse {
        private ServiceDto service;

        public ServiceDto getService() {
            return service;
        }

        public void setService(ServiceDto service) {
            this.service = service;
        }
    }
}
