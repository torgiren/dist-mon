/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AllServices;
import bean.GetAll;
import bean.LoginWrapper;
import bean.News;
import bean.Person;
import bean.Problem;
import bean.ProblemMain;
import bean.Service;
import bean.User;
import bean.json.ServiceMain;
import java.lang.annotation.Annotation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.UniversalService;

/**
 * Controler interact with jsp pages, functions inside this class are trigered
 * by them.
 * @author Maciej
 */

@Controller
public class IndexController{
         
    @Autowired
    private UniversalService universalService; 
    
    /**
     * 
     * @param universalService 
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    

    
        /**
     * Startin page 
     * @return ModelAndView with start page
     */
    @RequestMapping(value = "/")
    public ModelAndView start()
    {
        ModelAndView  mv = new ModelAndView("index");
        mv.addObject("title", "Witamy na stronie stowarzyszenia");
        mv.addObject("news", "Ząb zupa zębowa");
        return mv;
    }
    
    @RequestMapping(value="/problem", method = RequestMethod.GET)
    public @ResponseBody GetAll getProblems() {
        GetAll data = universalService.getAll();
        return data;
    }
   
    @RequestMapping(value="/problem", method = RequestMethod.POST)
    public @ResponseBody GetAll newProblem(@RequestBody ProblemMain problem) {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        universalService.newProblem(problem.getProblem());
        return new GetAll();
    }
    
    @RequestMapping(value = "/problem/{params}", method = RequestMethod.GET)
    public @ResponseBody ProblemMain getProblem(@PathVariable String params)
    {
        int id = Integer.parseInt(params);
        return universalService.getSpecifyProblem(id);
    }
    
    @RequestMapping(value = "/problem/{params}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> updateProblem(@PathVariable String params, 
            @ModelAttribute("problem") Problem problem)
    {
        int id = Integer.parseInt(params);
        universalService.updateProblem(problem);
        return new ResponseEntity<String>("",HttpStatus.OK);
    }
    
        @RequestMapping(value = "/service", method = RequestMethod.GET)
    public @ResponseBody AllServices getAllServices()
    {   
        return universalService.getAllServices();
    }
    
    @RequestMapping(value="/service", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> addService(@RequestBody ServiceMain service) {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        universalService.newService(service.getService());
        return new ResponseEntity<String>("",HttpStatus.OK);
    }
}
