import { Component } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Contract } from '../contract';
import { ResourceService } from '../resource.service';

@Component({
  selector: 'contracts',
  templateUrl: './contracts.component.html',
  providers: [ContractsService, ResourceService]
})
export class ContractsComponent {
    displayedColumns: string[] = ['id', 'start_time', 'end_time', 'customer'];

    contracts: Contract[] = [];

    constructor(private contractsService: ContractsService, private resourceService: ResourceService){}

    ngOnInit() {
        this.resourceService.checkCredentials();
        this.contractsService.getData().subscribe((data: Contract[]) => {
            this.contracts = data;
        });
    }
}
