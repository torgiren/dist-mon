package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.ServiceDto;
import is.agh.dist.mon.api.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MeasurmentController {

    @Autowired
    private MeasurementService measurementService;

    @RequestMapping(value = "/service/list")
    public ModelAndView listAction() {
        List<ServiceDto> services = measurementService.findAll();
        return new ModelAndView("service/list", "services", services);
    }

    @RequestMapping(value = "/service/{id}")
    public ModelAndView detailsAction(@PathVariable("id") Integer id) {
        try {
            ServiceDto service = measurementService.findById(id);
            return new ModelAndView("service/details", "service", service);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
