package is.agh.dist.mon.gui.web.bean;

import is.agh.dist.mon.api.dto.ServiceDto;
import is.agh.dist.mon.api.service.MeasurementService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MeasurementServiceBean implements Serializable {

    @Autowired
    private MeasurementService service;
    
    public List<ServiceDto> getServices() {
        return service.findAll();
    }
}
