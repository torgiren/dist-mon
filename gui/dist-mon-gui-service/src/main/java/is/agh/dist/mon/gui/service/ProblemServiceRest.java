package is.agh.dist.mon.gui.service;

import is.agh.dist.mon.api.dto.ProblemDto;
import is.agh.dist.mon.api.service.ProblemService;
import is.agh.dist.mon.gui.service.response.FindAllResponse;
import is.agh.dist.mon.gui.service.response.FindByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProblemServiceRest implements ProblemService {

    @Value("${catalog.address}")
    private String catalogAddress;
    @Value("${catalog.problem}")
    private String problemQuery;
    @Value("${catalog.problemById}")
    private String problemByIdQuery;
            
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProblemDto> findAll() {
        ResponseEntity<FindAll> response = restTemplate.getForEntity(catalogAddress + problemQuery, FindAll.class);
        return response.getBody().getEntries();
    }

    @Override
    public ProblemDto findById(int id) {
        ResponseEntity<FindById> response = restTemplate.getForEntity(catalogAddress + problemByIdQuery, FindById.class, id);
        return response.getBody().getEntry();
    }

    private static class FindAll extends FindAllResponse<ProblemDto> {
    }

    private static class FindById extends FindByIdResponse<ProblemDto> {
    }
}
