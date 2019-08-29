package autoservice.app.controllers;

import autoservice.app.domain.AdditionalAgreement;
import autoservice.app.domain.Contract;
import autoservice.app.dto.AdditionalAgreementDto;
import autoservice.app.dto.ContractDto;
import autoservice.app.services.AdditionalAgreementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    @PostMapping
    public ResponseEntity<Contract> saveContract(@RequestBody AdditionalAgreementDto dto) {
        if (Objects.isNull(dto)) {
            return ResponseEntity.badRequest().build();
        }
        AdditionalAgreement agreement = agreementsService.save(dto);
        return ResponseEntity.created(URI.create("agreements/" + agreement.getId())).build();

    }
}
