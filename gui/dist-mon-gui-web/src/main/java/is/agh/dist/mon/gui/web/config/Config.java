package is.agh.dist.mon.gui.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/beans.xml")
@ComponentScan(basePackages = "is.agh.zespolowe.monitoring.web")
public class Config {
    
}
