package autoservice.application.exceptions;

public class ContractNotFoundException extends RuntimeException {
    public ContractNotFoundException() {
    }

    public ContractNotFoundException(String message) {
        super(message);
    }
}
