package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.HostDetailsDto;
import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.dto.MonitorDto;
import is.agh.dist.mon.api.dto.ServiceDataDto;
import is.agh.dist.mon.api.dto.ServiceDto;
import is.agh.dist.mon.api.service.HostService;
import is.agh.dist.mon.api.service.MeasurementService;
import is.agh.dist.mon.api.service.MonitorService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HostController {

    @Autowired
    private HostService hostService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private MeasurementService measurementService;

    @RequestMapping(value = "/host/list")
    public ModelAndView listAction() {
        List<HostDto> hosts = hostService.findAll();
        return new ModelAndView("host/list", "hosts", hosts);
    }

    @RequestMapping(value = "/host/{id}")
    public ModelAndView detailsAction(@PathVariable("id") Integer id) {
        try {
            HostDetailsDto host = hostService.findById(id);
            return new ModelAndView("host/details", "host", host);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

    @RequestMapping(value = "/host/add")
    public ModelAndView addAction() {
        ModelAndView modelAndView = new ModelAndView("host/add", "host", new HostDto());

        Collection<MonitorDto> monitors = monitorService.findAll();
        modelAndView.addObject("availableMonitors", monitors);
        Collection<ServiceDto> services = measurementService.findAll();
        modelAndView.addObject("availableServices", services);

        return modelAndView;
    }

    @RequestMapping(value = "/host/add", method = RequestMethod.POST)
    public ModelAndView addAction(@ModelAttribute("host") HostDto host) {
        try {
            hostService.add(host);
            return new ModelAndView("redirect:/host/list");
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }
    
    @RequestMapping(value = "/serviceData/{id}/{serviceUrl}")
    public ModelAndView detailsDataAction(@PathVariable("id") Integer id, @PathVariable("serviceUrl") String serviceUrl) {
        try {
            ServiceDataDto service = hostService.findServiceDataById(serviceUrl, id);
            return new ModelAndView("host/serviceDetails", "service", service);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
