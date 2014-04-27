package is.agh.dist.mon.gui.web.bean;

import is.agh.dist.mon.api.dto.HostDto;
import is.agh.dist.mon.api.service.HostService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class HostBean implements Serializable {

    @Autowired
    private HostService hostService;

    public List<HostDto> getHosts() throws IOException {
        try {
            List<HostDto> hosts = hostService.findAll();
            return hosts;
        } catch (Exception exc) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(exc.getMessage()));
            context.getFlash().setKeepMessages(true);
            context.redirect(context.getRequestContextPath() + "/error.xhtml");
        }
        return null;
    }
}
