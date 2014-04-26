package is.agh.dist.mon.gui.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/beans.xml")
@Import(value = {ServiceConfig.class})
@ComponentScan(basePackages = {"is.agh.dist.mon.gui.web"})
public class WebConfig {
    
}
