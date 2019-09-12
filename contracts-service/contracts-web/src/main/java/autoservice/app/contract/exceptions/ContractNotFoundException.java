package autoservice.app.contract.exceptions;

public class ContractNotFoundException extends RuntimeException {
    public ContractNotFoundException() {
    }

    public ContractNotFoundException(String message) {
        super(message);
    }
}
