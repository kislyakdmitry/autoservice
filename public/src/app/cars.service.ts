import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ResourceService} from './resource.service';
import {Car} from './car';

@Injectable()
export class CarsService {
    constructor(private http: HttpClient, private resourceService: ResourceService) {
    }

    private carsUrl = 'http://localhost:8080/api/cars';

    getData(): Observable<Car[]> {
        return this.resourceService.getResource(this.carsUrl);
    }
}
