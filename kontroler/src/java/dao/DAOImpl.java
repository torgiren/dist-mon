/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import bean.GetAll;
import bean.Ids;
import bean.News;
import Exceptions.NotFoundExcepiton;
import bean.Person;
import bean.Problem;
import bean.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Class maintenance connection with database
 * @author Maciej
 */
public class DAOImpl  implements MainDAO  {
    private JdbcTemplate jdbcTemplate; 
 
    
    public void setDataSource(DataSource dataSource) { 
        this.jdbcTemplate = new JdbcTemplate(dataSource); 
    } 
 
    
    @Override
    public boolean addProblem(Problem problem)
    {
        String query = "INSERT INTO  problem(serviceId, hostId, status,"
                + " value, start, stop, ack) VALUES (?,?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(query, new Object[] { 
            problem.getServiceId(), problem.getHostId(),
                problem.getStatus(), problem.getValue(),
                problem.getStart(), problem.getStop(),
                problem.getAck()
            });
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    @Override
    public Problem[] getAllProblems()
    {
        String query = "SELECT * FROM problem"; 
        List<Problem> problem = null;
        
        try { 
            problem = jdbcTemplate.query(query, new BeanPropertyRowMapper(Problem.class));
        } catch (Exception ex){
            return null;
        }

        return problem.toArray(new Problem[problem.size()]);
    }

    @Override
    public Problem getSpecifyProblem(int id) 
    {
        String query = "SELECT * FROM problem WHERE ID="+id; 

        List<Problem> list;
        try { 
            list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Problem.class));
        } catch (Exception ex) {
            throw new NotFoundExcepiton();
        }
        
        if(list.isEmpty())
            throw new NotFoundExcepiton();
        
        return list.get(0);
    }
    
    @Override
    public Service[] getAllServices()
    {
        String query = "SELECT * FROM services"; 
        List<Service> service = null;
        
        try { 
            service = jdbcTemplate.query(query, new BeanPropertyRowMapper(Service.class));
        } catch (Exception ex){
            return null;
        }

        return service.toArray(new Service[service.size()]);
    }
    
    @Override
    public Ids[] getAll(String table)
    {
        String query = "SELECT id FROM " + table; 
        List<Ids> ids;
        try { 
            ids = jdbcTemplate.query(query, new BeanPropertyRowMapper(Ids.class));
        } catch (Exception ex){
            return null;
        }
        GetAll ol =  new GetAll();
        Ids[] o = ids.toArray(new Ids[ids.size()]);
        return o;
    }
    
    @Override
    public boolean addService(Service service) {
        String query = "INSERT INTO  service(name, command, args,"
                + " freq, hard, type) VALUES (?,?,?,?,?,?)"; 
        try
        {
        jdbcTemplate.update(query, new Object[] { 
        service.getName(), service.getCommand(),
            service.getArgs(), service.getFreq(),
            service.getHard(), service.getType()
        });
        }
        catch(Exception e){
            return false;
        }
        
        return true;
    }

    @Override
    public void updateProblem(Problem problem) {
        String query = "UPDATE  problem SET serviceId=?, hostId=?, status=?, " 
                + "value=?, start=?, stop=?, ack=?  WHERE ID=?"; 
        try
        {
        jdbcTemplate.update(query, new Object[] { 
            problem.getServiceId(), problem.getHostId(),
                problem.getStatus(), problem.getValue(),
                problem.getStart(), problem.getStop(),
                problem.getAck(), problem.getId()
            });
        }catch(Exception e)
        {
            throw new NotFoundExcepiton();
        }
    }
}
