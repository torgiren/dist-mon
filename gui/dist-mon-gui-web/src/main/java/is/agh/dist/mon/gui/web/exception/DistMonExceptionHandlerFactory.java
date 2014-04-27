package is.agh.dist.mon.gui.web.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class DistMonExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;
    
    public DistMonExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new DistMonExceptionHandler(parent.getExceptionHandler());
    }

}
