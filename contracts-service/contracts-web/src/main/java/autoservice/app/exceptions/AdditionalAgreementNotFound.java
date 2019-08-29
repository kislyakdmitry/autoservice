package autoservice.app.exceptions;

public class AdditionalAgreementNotFound extends RuntimeException {
    public AdditionalAgreementNotFound() {
        super();
    }

    public AdditionalAgreementNotFound(String message) {
        super(message);
    }
}
