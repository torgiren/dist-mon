/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.LoginWrapper;
import bean.News;
import bean.Person;
import bean.Problem;
import bean.User;
import dao.MainDAO;

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
}
