import { Component } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Contract } from '../contract';
import { ResourceService } from '../resource.service';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { AdditionalAgreementsService } from '../additional_agreements.service';
import { Agreement } from '../agreement';

@Component({
    selector: 'contract_details',
    templateUrl: './contract_details.component.html',
    providers: [ContractsService, ResourceService, AdditionalAgreementsService]
})
export class ContractDetailsComponent {
    contract: Contract = new Contract();
    agreements: Agreement[] = [];

    private subscription: Subscription;
    private id: number;

    constructor(private contractsService: ContractsService, private activateRoute: ActivatedRoute, private agreementsService: AdditionalAgreementsService) {
        this.subscription = activateRoute.params.subscribe(params => this.id = params['id']);
    }

    ngOnInit() {
        this.contractsService.getContract(this.id).subscribe((data: Contract) => {
            this.contract = data;
        });

        this.agreementsService.getData(this.id).subscribe((data: Agreement[]) => {
            this.agreements = data;
        });
    }
}
