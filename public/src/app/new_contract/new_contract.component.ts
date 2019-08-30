import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { CarsService } from '../cars.service'
import { Car } from '../car';
 
@Component({
  templateUrl: 'new_contract.component.html',
  providers: [ CarsService ]
})
export class NewContract {

  constructor(private carsService: CarsService){}

  public customerData = {
    firstName: '',
    lastName: ''
  }

  cars = new FormControl();
  carsList: Car[];

  ngOnInit(): void {
      this.carsService.getData().subscribe((data: Car[]) => {
        this.carsList = data;
    });
  }

  submit() {
    console.log(this.cars);
  }
}