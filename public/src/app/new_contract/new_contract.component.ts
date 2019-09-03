import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { CarsService } from '../cars.service';
import { ContractsService } from '../contracts.service';
import { Car } from '../car';
import { Contract } from '../contract';

@Component({
  templateUrl: 'new_contract.component.html',
  providers: [CarsService, ContractsService]
})
export class NewContract {

  constructor(private carsService: CarsService, private contractsService: ContractsService) { }

  public customerData = {
    firstName: '',
    lastName: ''
  }
  private startDate = new FormControl();
  private endDate = new FormControl();

  cars = new FormControl();
  carsList: Car[];

  ngOnInit(): void {
    this.carsService.getData().subscribe((data: Car[]) => {
      this.carsList = data;
    });
  }

  submit() {
    let contract = new Contract();
    contract.startDate = this.formatDate(this.startDate.value);
    contract.endDate = this.formatDate(this.endDate.value);
    contract.customer = {
      firstName: this.customerData.firstName,
      lastName: this.customerData.lastName
    }
    contract.carsVins = this.cars.value;
    this.contractsService.save(contract).subscribe(res => location.reload());
  }

  formatDate(value) {
    let formatedDate = new Date(value);
    return formatedDate.getFullYear() + '-' + (formatedDate.getMonth() + 1) + '-' + formatedDate.getDate();
  }
}