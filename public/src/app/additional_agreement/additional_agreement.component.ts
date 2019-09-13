import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { CarsService } from '../cars.service';
import { AdditionalAgreementsService } from '../additional_agreements.service';
import { Car } from '../car';
import { Agreement } from '../agreement'
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  templateUrl: 'additional_agreement.component.html',
  providers: [CarsService, AdditionalAgreementsService]
})
export class AdditionalAgreementComponent {

  private subscription: Subscription;
  private contractId: number;

  constructor(private carsService: CarsService,
    private agreementsService: AdditionalAgreementsService,
    private activateRoute: ActivatedRoute) {
    this.subscription = activateRoute.params.subscribe(params => this.contractId = params['id']);
  }

  car = new FormControl();
  carsList: Car[];

  ngOnInit(): void {
    this.carsService.getData().subscribe((data: Car[]) => {
      this.carsList = data;
    });
  }

  submit() {
    const agreement = new Agreement();
    agreement.carVin = this.car.value;
    this.agreementsService.save(this.contractId, agreement).subscribe(res => location.reload());
  }
}
