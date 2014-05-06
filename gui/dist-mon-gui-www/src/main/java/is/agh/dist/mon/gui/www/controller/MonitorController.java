package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.dto.MonitorDto;
import is.agh.dist.mon.api.service.HostService;
import is.agh.dist.mon.api.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
public class MonitorController {

    @Autowired
    private MonitorService monitorService;
    @Autowired
    private HostService hostService;

    @RequestMapping(value = "/monitor/list")
    public ModelAndView listAction() {
        List<MonitorDto> monitors = monitorService.findAll();
        return new ModelAndView("monitor/list", "monitors", monitors);
    }

    @RequestMapping(value = "/monitor/{id}")
    public ModelAndView detailsAction(@PathVariable("id") Integer id) {
        try {
            MonitorDto monitor = monitorService.findById(id);
            return new ModelAndView("monitor/details", "monitor", monitor);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

    @RequestMapping(value = "/monitor/add")
    public ModelAndView addAction() {
        ModelAndView modelAndView = new ModelAndView("monitor/add", "monitor", new MonitorDto());

        Collection<HostDto> hosts = hostService.findAll();
        modelAndView.addObject("availableHosts", hosts);

        return modelAndView;
    }

    @RequestMapping(value = "/monitor/add", method = RequestMethod.POST)
    public ModelAndView addAction(@ModelAttribute("monitor") MonitorDto monitor) {
        try {
            monitorService.add(monitor);
            return new ModelAndView("redirect:/monitor/list");
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
