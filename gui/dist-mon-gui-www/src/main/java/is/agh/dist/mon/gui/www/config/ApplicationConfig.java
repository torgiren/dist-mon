package is.agh.dist.mon.gui.www.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { ServiceConfig.class };
    }
 
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MvcConfig.class };
    }
 
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
     
}