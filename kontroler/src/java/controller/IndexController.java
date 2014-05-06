/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LoginWrapper;
import bean.News;
import bean.Person;
import bean.Problem;
import bean.Service;
import bean.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    //    News news[] = universalService.getNews();
        
       
   //     mv.addObject("titles", getShortTitles(news));
        mv.addObject("title", "Witamy na stronie stowarzyszenia");
        mv.addObject("news", "Ząb zupa zębowa");
        return mv;
    }
    @RequestMapping(value="/problem", method = RequestMethod.GET)
    public ModelAndView getProblems() {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        
      //  String data = universalService.getAllProblems();
        String data = universalService.getAll("problems");
        mav.addObject(("message"), data);
        return mav;
    }
    
    @RequestMapping(value="/problem", method = RequestMethod.POST)
    public ModelAndView newProblem(@ModelAttribute("problem") Problem problem) {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        String data = universalService.newProblem(problem);
        mav.addObject(("message"), data);
        return mav;
    }
    
    @RequestMapping(value = "/problem/{params}", method = RequestMethod.GET)
    public ModelAndView getProblem(@PathVariable String params)
    {
        int id = Integer.parseInt(params);
        ModelAndView mav = new ModelAndView("login", "user", new User());
        String data = universalService.getSpecifyProblem(id);
        mav.addObject(("message"), data);
        return mav;
    }
    
    @RequestMapping(value = "/problem/{params}", method = RequestMethod.POST)
    public ModelAndView updateProblem(@PathVariable String params, 
            @ModelAttribute("problem") Problem problem)
    {
        int id = Integer.parseInt(params);
        ModelAndView mav = new ModelAndView("login", "user", new User());
    //    problem.setId(id);
        String data = universalService.updateProblem(problem);
        mav.addObject(("message"), data);
        return mav;
    }
    
        @RequestMapping(value = "/service", method = RequestMethod.GET)
    public ModelAndView getAllServices()
    {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        
        String data = universalService.getAll("service");
        mav.addObject(("message"), data);
        return mav;
    }
    
    @RequestMapping(value="/service", method = RequestMethod.POST)
    public ModelAndView addService(@ModelAttribute("service") Service service) {
        ModelAndView mav = new ModelAndView("login", "user", new User());
        String data = universalService.newService(service);
        mav.addObject(("message"), data);
        return mav;
    }
}
