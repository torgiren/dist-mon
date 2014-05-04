package is.agh.dist.mon.gui.www.controller;

import is.agh.dist.mon.api.dto.ProblemDto;
import is.agh.dist.mon.api.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/problem/list")
    public ModelAndView listAction() {
        List<ProblemDto> problems = problemService.findAll();
        return new ModelAndView("problem/list", "problems", problems);
    }

    @RequestMapping(value = "/problem/{id}")
    public ModelAndView detailsAction(@PathVariable("id") Integer id) {
        try {
            ProblemDto problem = problemService.findById(id);
            return new ModelAndView("problem/details", "problem", problem);
        } catch (Exception exc) {
            return new ModelAndView("error", "exception", exc);
        }
    }

}
