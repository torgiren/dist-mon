/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.AllServices;
import bean.GetAll;
import bean.LoginWrapper;
import bean.News;
import bean.Person;
import bean.Problem;
import bean.ProblemMain;
import bean.Service;
import bean.User;
import dao.MainDAO;
import java.util.List;

/**
 * Model for web application
 * @author Maciej
 */
public class UniversalService {

    MainDAO personDAO;
    String loginPerson;
   
    public Problem getProblem(int problem)
    {
        personDAO.addProblem(new Problem());
        return new Problem();
    }
    
    /**
     * 
     * @param personDAO 
     */
    public void setPersonDAO(MainDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void newProblem(Problem problem) {        
        this.personDAO.addProblem(problem);
     }
    public void newService(Service service) {
        this.personDAO.addService(service);
    }

     public void updateProblem(Problem problem){
        this.personDAO.updateProblem(problem);
    }

    public GetAll getAll(){
        GetAll getAll = new GetAll();
        getAll.setProblem(this.personDAO.getAll("problem"));
        return getAll;
    }
    public AllServices getAllServices(){
        AllServices allServices = new AllServices();
        allServices.setService(this.personDAO.getAll("service"));
        return allServices;
    }
    
    public ProblemMain getSpecifyProblem(int id){
        Problem pr = this.personDAO.getSpecifyProblem(id);
        ProblemMain main = new ProblemMain();
        main.setProblem(pr);
        return main;
    }
    
}
