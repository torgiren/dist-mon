package is.agh.dist.mon.gui.web.exception;

import java.util.Iterator;
import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class DistMonExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler handler;

    public DistMonExceptionHandler(ExceptionHandler handler) {
        this.handler = handler;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return handler;
    }

    @Override
    public void handle() {
        final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator();
        while (it.hasNext()) {
            ExceptionQueuedEvent event = it.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable exc = context.getException();

            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
            final NavigationHandler nav = fc.getApplication().getNavigationHandler();
            
            try {
                requestMap.put("exceptionMessage", exc.getMessage());
                nav.handleNavigation(fc, null, "/error.xhtml");
                fc.renderResponse();
            } finally {
                it.remove();
            }
        }
        
        getWrapped().handle();
    }

}
