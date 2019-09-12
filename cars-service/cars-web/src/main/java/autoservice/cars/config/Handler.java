package autoservice.cars.config;

import autoservice.cars.car.exceptions.CarNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Handler {
    private Logger logger = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler(value = {
            CarNotFoundException.class,
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException(Exception ex) {
        logger.debug(ex.getMessage());
    }
}
