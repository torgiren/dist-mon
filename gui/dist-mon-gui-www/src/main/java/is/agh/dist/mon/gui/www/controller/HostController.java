package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HostController {

    @Autowired
    private HostService hostService;

    @RequestMapping(value = "/host/list")
    public ModelAndView listAction() {
        List<HostDto> hosts = hostService.findAll();
        return new ModelAndView("host/list", "hosts", hosts);
    }

    @RequestMapping(value = "/host/{id}")
    public ModelAndView detailsAction(@PathVariable("id") Integer id) {
        try {
            HostDto host = hostService.findById(id);
            return new ModelAndView("host/details", "host", host);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
