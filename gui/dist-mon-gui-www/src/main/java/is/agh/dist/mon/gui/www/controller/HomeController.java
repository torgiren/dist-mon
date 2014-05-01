package is.agh.dist.mon.gui.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView indexAction() {
        return new ModelAndView("home/index");
    }
}
