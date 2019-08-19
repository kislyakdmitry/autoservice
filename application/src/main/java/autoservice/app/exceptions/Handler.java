package autoservice.app.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Handler {
    private Logger logger = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler(value = {ContractNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleContractNotFoundException(ContractNotFoundException ex) {
        logger.debug(ex.getMessage());
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFoundException(UserNotFoundException ex) {
        logger.debug(ex.getMessage());
    }

    @ExceptionHandler(value = {CarNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCarNotFoundException(CarNotFoundException ex) {
        logger.debug(ex.getMessage());
    }
}
