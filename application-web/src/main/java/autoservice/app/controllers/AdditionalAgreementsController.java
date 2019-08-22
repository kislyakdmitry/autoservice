package autoservice.app.controllers;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.services.AdditionalAgreementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/agreements")
public class AdditionalAgreementsController {
    private AdditionalAgreementsService agreementsService;

    public AdditionalAgreementsController(AdditionalAgreementsService agreementsService) {
        this.agreementsService = agreementsService;
    }

    @GetMapping
    public ResponseEntity<List<AdditionalAgreement>> getAllAdditionalAgreements() {
        return ResponseEntity.ok(agreementsService.getAllAdditionalAgreements());
    }

    @GetMapping("/{agreementId}")
    public ResponseEntity<AdditionalAgreement> getAdditionalAgreementById(@PathVariable Long agreementId) {
        return ResponseEntity.ok(agreementsService.getAdditionalAgreementById(agreementId));
    }
}
