package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.service.HostService;
import is.agh.dist.mon.gui.www.model.AddHost;
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

    @RequestMapping(value = "/host/add")
    public ModelAndView addAction() {
        return new ModelAndView("host/add", "host", new HostDto());
    }

    @RequestMapping(value = "/note/add", method = RequestMethod.POST)
    public ModelAndView addAction(@ModelAttribute("host") HostDto host) {
        try {
            hostService.add(host);
            return new ModelAndView("redirect:/host/list");
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
