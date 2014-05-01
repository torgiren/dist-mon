package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.service.HostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HostController {
    @Autowired
    private HostService hostService;
   
    @RequestMapping(value = "/host/list")
    public ModelAndView indexAction() {
        List<HostDto> hosts = hostService.findAll();
        return new ModelAndView("host/list", "hosts", hosts);
    }
}
