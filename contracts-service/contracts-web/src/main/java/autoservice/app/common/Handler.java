package autoservice.app.common;

import autoservice.app.additional_agreement.exceptions.AdditionalAgreementBadRequest;
import autoservice.app.additional_agreement.exceptions.AdditionalAgreementNotFound;
import autoservice.app.car.exceptions.CarNotFoundException;
import autoservice.app.contract.exceptions.ContractBadRequest;
import autoservice.app.contract.exceptions.ContractNotFoundException;
import autoservice.app.customer.CustomerNotFoundException;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class Handler {
    private Logger logger = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler(value = {
            ContractNotFoundException.class,
            CustomerNotFoundException.class,
            CarNotFoundException.class,
            AdditionalAgreementNotFound.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException(Exception ex) {
        logger.debug(ex.getMessage());
    }

    @ExceptionHandler(value = {
            AdditionalAgreementBadRequest.class,
            ContractBadRequest.class
    })
    public ResponseEntity<Map<String, String>> handleBadRequestException(Exception ex) {
        Map<String, String> body = Maps.newHashMap();
        body.put("Reason: ", ex.getMessage());
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("X-Status-Reason", "Validation failed");
        logger.debug(ex.getMessage());
        return ResponseEntity.badRequest().headers(respHeaders).body(body);
    }
}
