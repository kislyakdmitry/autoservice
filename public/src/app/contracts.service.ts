import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Contract} from './contract';
import {Observable} from 'rxjs';
import {ResourceService} from './resource.service';

@Injectable()
export class ContractsService {
    constructor(private http: HttpClient, private resourceService: ResourceService) {
    }

    private contractsUrl = 'http://localhost:8080/api/contracts';

    getData(): Observable<Contract[]> {
        return this.resourceService.getResource(this.contractsUrl);
    }

    save(contract: Contract) {
        return this.resourceService.save(this.contractsUrl, contract);
    }
}
