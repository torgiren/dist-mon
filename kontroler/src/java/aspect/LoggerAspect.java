/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aspect;

import bean.LoginWrapper;
import bean.Person;
import dao.MainDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import service.UniversalService;

/**
 * This aspect class log users whos login in to the 
 * administration panel
 * 
 * @author Maciej
 */
@Aspect public class LoggerAspect { 
    
    File plik = new File("logi.txt");
    
    UniversalService universalService = new UniversalService();
    @Pointcut("execution(* service.*.*(..))") 
    private void selectAll(){} 

    @Pointcut("execution(* service.UniversalService.logIn(..))") 
    private void getPerson(){} 

    /**
     * Aspect trigered after returning value from logIn function
     * 
     * @param retVal represent class Person where we have information
     * about user who was login in to the administration panel
     */
    @AfterReturning(pointcut = "getPerson()", returning="retVal") 
    public void afterReturningMethod(Object retVal){ 
        System.out.println("Method getPerson() returning:" + retVal.toString() );
        LoginWrapper prs = (LoginWrapper) retVal;
        if(prs.getPerson().getUserLogin() == null) return;
        try
        {
            Date dNow = new Date();
            SimpleDateFormat ft = 
                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            PrintWriter zapis = new PrintWriter("logi.txt");
            zapis.println(prs.getPerson().getUserLogin() + " " + ft.format(dNow));
            zapis.close();
        }
        catch(Exception e)
        {
            
        }
    }
}
