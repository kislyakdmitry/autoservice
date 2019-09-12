package autoservice.app.additional_agreement.exceptions;

public class AdditionalAgreementNotFound extends RuntimeException {
    public AdditionalAgreementNotFound() {
        super();
    }

    public AdditionalAgreementNotFound(String message) {
        super(message);
    }
}
