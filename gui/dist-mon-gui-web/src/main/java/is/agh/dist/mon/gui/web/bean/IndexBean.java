package is.agh.dist.mon.gui.web.bean;

import java.io.Serializable;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class IndexBean implements Serializable {
    
    @Inject
    HelloBean helloBean;
    
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String getMessage() {
        return helloBean.getMessage();
    }
}
