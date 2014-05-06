/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.GetAll;
import bean.Problem;
import bean.Service;
/**
 *
 * @author Maciej
 */
public interface MainDAO {
    public boolean addProblem(Problem problem);
    public boolean updateProblem(Problem problem);
    Problem[] getAllProblems();
    GetAll[] getAll(String table);
    public Problem getSpecifyProblem(int id);
    public Service[] getAllServices();
    
    public boolean addService(Service service);
}
