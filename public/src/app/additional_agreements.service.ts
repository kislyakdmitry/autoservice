import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ResourceService} from './resource.service';
import { Agreement } from './agreement';

@Injectable()
export class AdditionalAgreementsService {
    constructor(private http: HttpClient, private resourceService: ResourceService) {
    }

    private contractsUrl = 'http://localhost:8080/api/contracts/';

    getData(contractId: number): Observable<Agreement[]> {
        return this.resourceService.getResource(this.contractsUrl + contractId + '/agreements');
    }

    save(contractId: number, agreement: Agreement) {
        return this.resourceService.save(this.contractsUrl + contractId + '/agreements', agreement);
    }
}
