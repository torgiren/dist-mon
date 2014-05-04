/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import bean.News;
import bean.Person;
import bean.Problem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    public void addProblem(Problem problem)
    {
        String query = "INSERT INTO  problems(id, id2) VALUES (?,?)"; 
        jdbcTemplate.update(query, new Object[] { 
        1,2
        });
    }
}
