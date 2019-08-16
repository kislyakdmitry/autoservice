import { Component } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Contract } from '../contract';

@Component({
  selector: 'contracts',
  templateUrl: './contracts.component.html',
  providers: [ContractsService]
})
export class ContractsComponent {
    displayedColumns: string[] = ['id', 'start_time', 'end_time', 'manager'];

    contracts: Contract[] = [];

    constructor(private contractsService: ContractsService){}

    ngOnInit(){
        //console.log(this.contractsService.getData());
        this.contractsService.getData().subscribe((data: Contract[]) => {
            this.contracts = data;
            console.log(this.contracts);
        });
    }
}
