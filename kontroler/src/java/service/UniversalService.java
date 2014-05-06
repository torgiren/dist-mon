/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.GetAll;
import bean.LoginWrapper;
import bean.News;
import bean.Person;
import bean.Problem;
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

    public String newProblem(Problem problem) {        
        if(this.personDAO.addProblem(problem)){
            return "{'status': 200}";
        }
        return "{'status': 404}";
     }
    public String newService(Service service) {
        if(this.personDAO.addService(service)){
            return "{'status': 200}";
        }
        return "{'status': 404}";
    }
    
    public String updateProblem(Problem problem){
        if(this.personDAO.updateProblem(problem)){
            return "{'status': 200}";
        }
        return "{'status': 404}";
    }
    public String getAllProblems() {
      Problem[] problems = this.personDAO.getAllProblems();
      
      int size = problems.length;
      int i = 0;
      String[] json = new String[size]; 
      for (Problem problem : problems){
          json[i++] = "{" + " 'id': '" + problem.getId() + "' } ";
      }
      return parseJson("problem", json);
    }
    
    public String getAll(String table){
      GetAll[] ids = this.personDAO.getAll(table);
      
      int size = ids.length;
      int i = 0;
      String[] json = new String[size]; 
      for (GetAll id : ids){
          json[i++] = "{" + " 'id': '" + id.getId() + "' } ";
      }
      return parseJson("problem", json);
    }
    
    public String getSpecifyProblem(int id){
        Problem problem = this.personDAO.getSpecifyProblem(id);
        String json = "";
        
        if (problem != null)
        {
            json = problem.getJsonRow();
        }
        
        
        json = paresJson("problem", json);
        return json;
    }
    
    private String paresJson(String name, String row)
    {
        if(row.isEmpty())
        {
           return parseJson(name, new String[] {}); 
        }
        return parseJson(name, new String[] {row});
    }
    
    private String parseJson(String name, String []rows){
        String jsonString = "{'" + name + "':";
        int size = rows.length;
        int i = 0;
        String statusCode = "200";
        if(rows.length == 0)
        {
            jsonString += "{}";
            statusCode = "404";
        }
        else if(rows.length == 1)
        {
            jsonString += rows[0];
        }
        else
        {
            jsonString += "[";
            for(String row : rows)
            {
                jsonString += row;
                if(++i != size) jsonString += ",";
            }
            jsonString += "]";
        }
        jsonString += ", 'status':" + statusCode;
        jsonString += "}";
        
        return jsonString;
    }
}
