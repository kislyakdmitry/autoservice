package autoservice.app.exceptions.handlers;

import autoservice.app.exceptions.AdditionalAgreementNotFound;
import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.exceptions.ContractNotFoundException;
import autoservice.app.exceptions.UserNotFoundException;
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
            ContractNotFoundException.class,
            UserNotFoundException.class,
            CarNotFoundException.class,
            AdditionalAgreementNotFound.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException(Exception ex) {
        logger.debug(ex.getMessage());
    }
}
