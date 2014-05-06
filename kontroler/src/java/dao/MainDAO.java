/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.GetAll;
import bean.Ids;
import bean.Problem;
import bean.Service;
/**
 *
 * @author Maciej
 */
public interface MainDAO {
    public boolean addProblem(Problem problem);
    public void updateProblem(Problem problem);
    Problem[] getAllProblems();
    public Ids[] getAll(String table);
    public Problem getSpecifyProblem(int id);
    public Service[] getAllServices();
    
    public boolean addService(Service service);
}
